package com.unesasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created by Slavyanin on 21.07.2015.
 */

@Controller
public class HomePageController {
    @RequestMapping("/index")
    public String hello(Model model) {

        return "index";

    }

    @RequestMapping(value="/locale", method = RequestMethod.GET)
    public String user(Locale locale){
        return "index";//new ModelAndView("userform","user",new User());
    }
}
