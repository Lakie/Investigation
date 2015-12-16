package com.unesasoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * Created by Slavyanin on 21.07.2015.
 */

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);
        int i =0;
        i++;
        //returns the view name
        return "helloworld";

    }

}