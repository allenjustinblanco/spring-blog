package com.codeup.springblog;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class MathController {
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
    @RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @RequestMapping(path = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }
}
