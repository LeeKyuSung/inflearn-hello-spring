package com.example.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates/hello.html
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // resources/templates/hello-template.html
    }
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam String name) {
        return "hello " + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // JSON 형식으로 반환
    }
    static class Hello {
        private String name;
        // getter, setter
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
