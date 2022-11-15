package com.gachaapi;

import com.gachaapi.Security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class GachaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GachaApiApplication.class, args);
    }

}
