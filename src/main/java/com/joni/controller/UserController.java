package com.joni.controller;

import com.joni.model.User;
import com.joni.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shenjiajun on 2017/4/4.
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/api/SignUp", method = RequestMethod.POST)
    public ModelAndView signUp(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "pass") String pass,
                               @RequestParam(value = "userIntro") String userIntro) {
        ModelAndView modelAndView = new ModelAndView("/test");

        User user = new User(userName, pass);
        user.setUserIntro(userIntro);
        userService.insertUser(user);
        return modelAndView;
    }
}
