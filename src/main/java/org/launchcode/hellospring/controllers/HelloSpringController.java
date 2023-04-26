package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloSpringController {
    @RequestMapping(value = "hello", method ={RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!!!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    //handles path hello/name
    @GetMapping("hello/{name}")
    public String helloPath(@PathVariable String name, Model model){
        String greeting = "Hello" + name + "XXX";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }
    @GetMapping
    @ResponseBody
    public String hello(){
        return "Hello, Spring!";
    }

    //Handles requests at /goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handler for /shello/?name=LaunchCode
    //shello is used to avoid issues with hello
    @GetMapping("shello")
    @ResponseBody
    public String helloQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Mike");
        names.add("Sarah");
        names.add("Violet");
        names.add("Jersey");
        names.add("Sigmund");
        model.addAttribute("names", names);
        return "hello-list";

    }
}
