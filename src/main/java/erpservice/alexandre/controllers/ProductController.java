package erpservice.alexandre.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    @Value("${api.baseurl}")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, world!";
    }
}
