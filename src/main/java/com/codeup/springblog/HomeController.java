package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Integer.parseInt;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() { return "home"; }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String rollDice(@PathVariable String n, Model model){
        int randomNumber = (int) ((Math.random() * 6) + 1);
        if(parseInt(n) == randomNumber){
            model.addAttribute("n", n);
            return "You guessed the number correctly";
        } else {
            model.addAttribute("n", n);
            return "You guessed wrong!";
        }
    }

}
