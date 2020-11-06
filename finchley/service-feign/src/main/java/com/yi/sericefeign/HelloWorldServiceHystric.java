package com.yi.sericefeign;

import org.springframework.stereotype.Component;

/**
 * @author yilei
 * @version 1.0
 * @description TODO
 * @className SchedualServiceHiHystric
 * @date 2020/9/27 23:15
 **/
@Component
public class HelloWorldServiceHystric implements HelloWorldService {
    @Override
    public String helloWorld(String name) {
        return "hello world: " + name + " 服务暂未提供！";
    }
}
