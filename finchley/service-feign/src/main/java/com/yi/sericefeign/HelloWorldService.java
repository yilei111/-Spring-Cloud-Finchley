package com.yi.sericefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yilei
 * @version 1.0
 * @description TODO
 * @className HelloWorldService
 * @date 2020/9/27 22:22
 **/
@FeignClient(value = "service-client",fallback = HelloWorldServiceHystric.class)
public interface HelloWorldService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String helloWorld(@RequestParam(value = "name") String name);
}
