package org.luvom.mockmicroservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/debug")
public class DebugController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/beans")
    public List<String> getControllerBeans() {
        return Arrays.stream(applicationContext.getBeanDefinitionNames())
                .filter(name -> name.contains("Controller"))
                .collect(Collectors.toList());
    }
}