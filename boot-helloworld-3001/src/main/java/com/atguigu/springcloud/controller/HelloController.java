package com.atguigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * That is because @RestController combines @Controller and @ResponseBody,
 * two annotations that results in web requests returning data rather than
 * a view.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

}