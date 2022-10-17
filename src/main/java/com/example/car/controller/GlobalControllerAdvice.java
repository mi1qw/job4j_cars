package com.example.car.controller;

import jakarta.persistence.OptimisticLockException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({OptimisticLockException.class})
    public ModelAndView handleConflict(final HttpServletRequest request,
                                       final Exception e) {
        ModelAndView modelAndView = new ModelAndView("error/409");
        modelAndView.addObject("url", request.getRequestURL());
        return modelAndView;
    }
}
