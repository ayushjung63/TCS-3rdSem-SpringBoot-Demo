package com.tcs.demo.controller;

import com.tcs.demo.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/sayHello",method = RequestMethod.GET)
    public String callHelloService(){
        return helloService.sayHello();
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello "+name;
    }

    @RequestMapping(value = "/greet/{message}",method = RequestMethod.GET)
    public String greet(@PathVariable("message") String message){
        return message;
    }


}
