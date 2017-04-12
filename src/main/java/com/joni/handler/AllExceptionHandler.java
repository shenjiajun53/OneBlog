package com.joni.handler;

import com.joni.controller.UserController;
import com.joni.exception.UserNotFoundException;
import com.joni.model.Error;
import com.joni.model.Response;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by shenjj on 2017/4/12.
 */

@ControllerAdvice
public class AllExceptionHandler {
    private static Logger logger = Logger.getLogger(UserController.class);

    @ExceptionHandler(value = UserNotFoundException.class)
    public Response<Object> handleUserNotFoundException() {
        logger.debug("handleUserNotFoundException!!!!!!!!!");
        Response<Object> response = new Response(null, new Error("1", "没有此用户"));
        return response;
    }
}
