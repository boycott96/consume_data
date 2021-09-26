package com.jrhl;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = {"com.jrhl.**"})
//@MapperScan({"com.jrhl.dao.**"})
public class ConsumeDataSystem {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeDataSystem.class, args);
    }
}
