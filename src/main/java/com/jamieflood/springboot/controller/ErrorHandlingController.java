package com.jamieflood.springboot.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandlingController implements ErrorController{

    private static final String PATH = "/error";
    private static final String ERROR_MESSAGE = "An unexpected error has occurred. If you feel this is important you may report it <a href='https://github.com/jamieflood95/spring-boot-music-application/issues'>here</a> ";

    @RequestMapping(value = PATH)
    public String error() {

        return ERROR_MESSAGE;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}