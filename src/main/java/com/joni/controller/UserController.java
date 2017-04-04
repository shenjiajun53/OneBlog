package com.joni.controller;

import com.joni.model.User;
import org.jboss.logging.Logger;
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
    @RequestMapping(value = "/api/SignUp", method = RequestMethod.POST)
    public ModelAndView signUp(@RequestParam(value = "userName") String userName) {
        ModelAndView modelAndView = new ModelAndView("/test");
        System.out.printf("username=" + userName);
        User user = new User(userName);
        user.setPass("654321");
        return modelAndView;
    }
}
