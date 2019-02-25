package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    @RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int a, @PathVariable int b) {
        return a +" plus "+ b + " is " + (a + b);
    }

    @RequestMapping(path = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int a, @PathVariable int b) {
        return b + " minus " + a + " is " + (b - a);
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return a + " times " + b + " equals " + (a * b);
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int a, @PathVariable int b) {
        return a + " divided by " + b + " equals " + (a / b);
    }
}
