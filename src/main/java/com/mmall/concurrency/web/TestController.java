package com.mmall.concurrency.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    private static int count = 1;

    @RequestMapping("/test")
    public String test(){
        count += 1;
        log.info("请求进来了count:" + count);
        return "test";
    }
}
