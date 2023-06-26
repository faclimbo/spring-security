package com.sofia.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String getDemo() {
        return ("<h1>Spring Security Test Demo Successful</h1>");
    }

    @GetMapping("/one")
    public String getDemoOne() {
        return ("<h1>Spring Security Test Demo 1 Successful</h1>");
    }

    @GetMapping("/two")
    public String getDemoTwo() {
        return ("<h1>Spring Security Test Demo 2 Successful</h1>");
    }

    @GetMapping("/three")
    public String getDemoThree() {
        return ("<h1>Spring Security Test Demo 3 Successful</h1>");
    }


}
