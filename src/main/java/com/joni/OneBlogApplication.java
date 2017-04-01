package com.joni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class OneBlogApplication {
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }

    public static void main(String[] args) {
        SpringApplication.run(OneBlogApplication.class, args);
    }
}
