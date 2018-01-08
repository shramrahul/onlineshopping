package com.shram.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandleExceptionFound(){
        ModelAndView mv= new ModelAndView("error");
        mv.addObject("errorTitle","page Is NOt Constructed");
        mv.addObject("errorDescription","This page you are looking for is not available");
        mv.addObject("title","404 Error page");
        return mv;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleProductNotFoundExceptionFound(ProductNotFoundException exception){
        ModelAndView mv= new ModelAndView("error");
        mv.addObject("errorTitle","Product not available");
        mv.addObject("errorDescription",exception.getMessage());
        mv.addObject("title","Product Unavailable");
        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleExceptionFound(Exception exception){
        ModelAndView mv= new ModelAndView("error");
        mv.addObject("errorTitle","Contact your administrator");
        mv.addObject("errorDescription",exception.toString());
        mv.addObject("title","Error");
        return mv;
    }
}
