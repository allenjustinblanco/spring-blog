package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return "This is the Landing Page!";
    }

    @GetMapping("/roll-dice/{n}")
    public int rollDice(@PathVariable String n){
        return (int) (Math.random() * 6) + 1;
    }
}
