package com.joni.controller;

import com.joni.model.User;
import com.joni.service.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        ModelAndView modelAndView = new ModelAndView("/index");

        User user = new User(userName, pass);
//        user.setUserIntro(userIntro);
        userService.insertUser(user);
        return modelAndView;
    }

    @RequestMapping(value = "/api/SignIn", method = RequestMethod.POST)
    public ModelAndView signIn(@RequestParam(value = "userName") String userName,
                               @RequestParam(value = "pass") String pass) {
        System.out.println("userName=" + userName);
        ModelAndView modelAndView = new ModelAndView("/index");
//
      userService.findUserByName(userName);
//        User user2 = userList.get(0);
//        System.out.printf("find user=" + user.toString());
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping(value = "/api/SignIn", method = RequestMethod.POST)
//    public ModelAndView signIn(HttpServletRequest request, @RequestBody User user) {
//        System.out.printf("userName=" + user.toString());
//        ModelAndView modelAndView = new ModelAndView("/index");
////
////        List<User> userList = userService.findUserByName(userName);
////        User user2 = userList.get(0);
////        System.out.printf("find user=" + user2.toString());
//        return modelAndView;
//    }
}
