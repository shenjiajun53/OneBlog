package com.joni.controller;

import com.joni.exception.UserNotFoundException;
import com.joni.model.*;
import com.joni.model.Error;
import com.joni.service.UserService;
import com.joni.utils.FileUtil;
import com.mongodb.DuplicateKeyException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

/**
 * Created by shenjiajun on 2017/4/4.
 */

@ControllerAdvice
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TokenBasedRememberMeServices rememberMeServices;

    @Autowired
    ApplicationContext applicationContext;

    private static Logger logger = Logger.getLogger(UserController.class);


    @RequestMapping(value = "/api/SignUp", method = RequestMethod.POST)
    public Response<BaseBean> signUp(@RequestParam(value = "userName") String userName,
                                     @RequestParam(value = "pass") String pass,
                                     @RequestParam(value = "userIntro") String userIntro,
                                     @RequestParam("avatar") MultipartFile avatar) {
        ModelAndView modelAndView = new ModelAndView("/index");

        User user = new User(userName, pass);
        user.setUserIntro(userIntro);
        if (!avatar.isEmpty()) {
            try {
                String staticPath = System.getProperty("user.dir") + "/src/main/webapp";
                String filePath = "/files/avatar/";
                FileUtil.createOrExistsDir(staticPath + filePath);

                String fileName = System.currentTimeMillis() + "-" + avatar.getOriginalFilename();
                File file = new File(staticPath + filePath + fileName);
                avatar.transferTo(file);
                user.setAvatarPath(filePath+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        userService.insertUser(user);
        BaseBean baseBean;
        if (!user.getId().equals("")) {
            baseBean = new BaseBean(1);
        } else {
            baseBean = new BaseBean(2);
        }
        return new Response<>(baseBean, null);
    }

    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.POST)
    public Response<User> getUserInfo(@AuthenticationPrincipal User user) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = null;
//        if (authentication.getPrincipal() instanceof User) {
//            user = (User) authentication.getPrincipal();
//        }
//        System.out.println("User=" + user.toString());
        Response<User> response = new Response<>(user, null);
        return response;
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public Response<Object> handleUserNotFoundException() {
        System.out.println("handleUserNotFoundException!!!!!!!!!");
        Response<Object> response = new Response(null, new Error("1", "没有此用户"));
        return response;
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public Response<Object> handleDuplicateKeyException() {
        System.out.println("handleDuplicateKeyException!!!!!!!!!");
        Response<Object> response = new Response(null, new Error("1", "此用户名已被占用"));
        return response;
    }

    @RequestMapping(value = "/api/SignInSuccess", method = RequestMethod.GET)
    public Response<RedirectBean> signInSuccess() {
        RedirectBean redirectBean = new RedirectBean("/");
        Response<RedirectBean> response = new Response<>(redirectBean, null);
        return response;
    }

    @RequestMapping(value = "/api/SignInFailed", method = RequestMethod.GET)
    public Response<RedirectBean> signInFailed() {
        RedirectBean redirectBean = new RedirectBean("/");
        Response<RedirectBean> response = new Response<>(null, new Error("1", "用户名或密码错误"));
        return response;
    }

    @RequestMapping(value = "/api/SignOutSuccess", method = RequestMethod.GET)
    public Response<RedirectBean> signOutSuccess() {
        RedirectBean redirectBean = new RedirectBean("/");
        Response<RedirectBean> response = new Response<>(redirectBean, null);
        return response;
    }

//    @RequestMapping(value = "/api/SignIn", method = RequestMethod.POST)
//    public ModelAndView signIn(@AuthenticationPrincipal User user, @RequestParam(value = "username") String username,
//                               @RequestParam(value = "password") String password,
//                               HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        rememberMeServices.autoLogin(httpServletRequest, httpServletResponse);
//
//
//        Object user1 = authentication.getPrincipal();
//        System.out.println("userName=" + user1.toString());
//        ModelAndView modelAndView = new ModelAndView("/index");
////
//        userService.findUserByName(username);
////        User user2 = userList.get(0);
////        System.out.printf("find user=" + user.toString());
//        return modelAndView;
//    }
}
