package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() { return "home"; }

//    @PostMapping("/contact")
//    public String Contact(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, Model model) {
//        model.addAttribute("firstname", firstname);
//        model.addAttribute("lastname", lastname);
//        model.addAttribute("email", email);
//        return "contact";
//    }

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
