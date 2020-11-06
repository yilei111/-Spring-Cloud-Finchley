package com.yi.sericefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yilei
 * @version 1.0
 * @description TODO
 * @className HiController
 * @date 2020/9/27 22:23
 **/
@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping(value = "/helloWorld")
    public String helloWorld(@RequestParam String name) {
        System.out.println("...............service-feign");
        return helloWorldService.helloWorld(name);
    }
}
