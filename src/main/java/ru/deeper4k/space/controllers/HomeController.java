package ru.deeper4k.space.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Index page controller
 *
 * @author Albert Gazizov
 */
@Controller
public class HomeController {

    /**
     * Home page
     * @return index
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
