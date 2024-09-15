package com.jyc.nustudymate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jyc.nustudymate.mapper")
public class NuStudyMateApplication {

    public static void main(String[] args) {
        SpringApplication.run(NuStudyMateApplication.class, args);
    }

}
