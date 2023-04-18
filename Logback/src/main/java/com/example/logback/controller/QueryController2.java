package com.example.logback.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController2 {

//    public static final Logger log = LoggerFactory.getLogger(QueryController2.class);
    public static final Logger log = LoggerFactory.getLogger("SQL_LOG2");

    @GetMapping("/query2")
    public String query2(){

        log.trace("logback trace");
        log.debug("logback debug");
        log.info("logback info");
        log.warn("logback warn");
        log.error("logback error");

        return "query2";

    }
}