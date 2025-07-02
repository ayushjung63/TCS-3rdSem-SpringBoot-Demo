package com.tcs.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class HelloService {

    public String sayHello() {
        return "Hello World From the Service!";
    }
}
