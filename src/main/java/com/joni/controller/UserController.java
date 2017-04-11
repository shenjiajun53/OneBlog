package com.joni.controller;

import com.joni.model.Response;
import com.joni.model.User;
import com.joni.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

/**
 * Created by shenjiajun on 2017/4/4.
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    TokenBasedRememberMeServices rememberMeServices;


    @RequestMapping(value = "/api/SignUp", method = RequestMethod.POST)
    public ModelAndView signUp(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "pass") String pass,
                               @RequestParam(value = "userIntro") String userIntro) {
        ModelAndView modelAndView = new ModelAndView("/index");

        User user = new User(userName, pass);
        user.setUserIntro(userIntro);
        userService.insertUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.POST)
    public Response<User> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
//        System.out.println("User=" + user.toString());
        Response<User> response = new Response<>(user, null);
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
