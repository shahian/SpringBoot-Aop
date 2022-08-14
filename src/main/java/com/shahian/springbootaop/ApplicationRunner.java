package com.shahian.springbootaop;

import com.shahian.springbootaop.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {
    @Autowired
    BusinessService businessService;

    @Override
    public void run(String... args) throws Exception {
        businessService.createEmployee("Shahian","10");
        businessService.deleteEmployee("100");
        businessService.saveEmployee();
        businessService.testMethodforAroundAdvice();
        businessService.saveEmployee();

    }
}
