package com.joni.controller;

import com.joni.exception.UserNotFoundException;
import com.joni.model.*;
import com.joni.model.Error;
import com.joni.service.UserService;
import com.joni.utils.FileUtil;
import com.mongodb.DuplicateKeyException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
    ApplicationContext applicationContext;

    private static Logger logger = Logger.getLogger(UserController.class);

    @RequestMapping(value = "/api/SignIn", method = RequestMethod.POST)
    private Response<RedirectBean> signIn(@RequestParam(value = "userName") String userName,
                                          @RequestParam(value = "pass") String pass) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, pass, true);
        try {
            SecurityUtils.getSubject().login(token);
        } catch (IncorrectCredentialsException e) {
            throw e;
        } catch (AuthenticationException e) {
            throw new UserNotFoundException();
        }
        RedirectBean redirectBean = new RedirectBean("/");
        Response<RedirectBean> response = new Response<>(redirectBean, null);
        return response;
    }

    @RequestMapping(value = "/api/SignUp", method = RequestMethod.POST)
    public Response<BaseBean> signUp(@RequestParam(value = "userName") String userName,
                                     @RequestParam(value = "pass") String pass,
                                     @RequestParam(value = "userIntro") String userIntro,
                                     @RequestParam("avatar") MultipartFile avatar) {
        ModelAndView modelAndView = new ModelAndView("/index");

        System.out.printf("signUp!!!!");
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
                user.setAvatarPath(filePath + fileName);
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

    @RequestMapping("/api/SignOut")
    public Response<RedirectBean> signOut() {
        SecurityUtils.getSubject().logout();
        RedirectBean redirectBean = new RedirectBean("/");
        Response<RedirectBean> response = new Response<>(redirectBean, null);
        return response;
    }

    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.POST)
    public Response<User> getUserInfo() {
        Subject subject = SecurityUtils.getSubject();
        String userId = (String) subject.getPrincipal();
        System.out.printf("userId=" + userId);
        User user = userService.findUserById(userId);
        Response<User> response = new Response<>(user, null);
        return response;
    }

    @ExceptionHandler(value = IncorrectCredentialsException.class)
    public Response<Object> handleIncorrectCredentialsException() {
        System.out.println("handleUserNotFoundException!!!!!!!!!");
        Response<Object> response = new Response(null, new Error("1", "用户名或密码错误"));
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
        System.out.printf("signInSuccess");
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
}
