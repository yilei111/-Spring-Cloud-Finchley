package com.yi.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yilei
 * @version 1.0
 * @description TODO
 * @className HelloService
 * @date 2020/9/27 21:39
 **/
@Service
@DefaultProperties(defaultFallback = "defaultCallBack")
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(commandProperties = {
                @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 触发熔断的最小请求次数
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 休眠时间
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT/hello?name=" + name, String.class);
    }

    public String helloHystrix(String name) {
        return "hello :"+name+",服务繁忙，稍后再试!";
    }
}
