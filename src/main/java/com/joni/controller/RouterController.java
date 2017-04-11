package com.joni.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shenjiajun on 2017/4/4.
 */
@RestController
public class RouterController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

    @RequestMapping(value = "/SignIn")
    public ModelAndView signIn() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

    @RequestMapping(value = "/SignUp")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

    @RequestMapping(value = "/MyFollow")
    public ModelAndView myFollow() {
        ModelAndView modelAndView = new ModelAndView("/test");

        return modelAndView;
    }

    @RequestMapping(value = "/WriteBlog")
    public ModelAndView writeBlog() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

    @RequestMapping(value = "/BlogDetail/*")
    public ModelAndView blogDetail() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

}
