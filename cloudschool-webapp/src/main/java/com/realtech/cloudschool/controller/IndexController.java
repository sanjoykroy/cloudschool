package com.realtech.cloudschool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private static final String INDEX_VIEW = "index";

    @RequestMapping(value="/")
    public String index() {
        LOGGER.info("Showing index page");
        return INDEX_VIEW;
    }
}
