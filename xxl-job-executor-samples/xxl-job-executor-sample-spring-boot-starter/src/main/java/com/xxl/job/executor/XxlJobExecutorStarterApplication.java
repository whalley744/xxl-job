package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Whalley
 * @since 2021/4/5
 */
@RestController
@SpringBootApplication
public class XxlJobExecutorStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxlJobExecutorStarterApplication.class);
    }

    @GetMapping
    public String index() {
        return "<h1>Hello,World!";
    }

}
