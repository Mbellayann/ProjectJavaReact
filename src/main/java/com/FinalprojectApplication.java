package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FinalprojectApplication {

    public static void main(String[] args) throws IOException {
        /** SpringApplication springBootApplication =
         new SpringApplication(FinalprojectApplication.class);
         String filelocation = System.getProperty("application-properties-file");
         Properties properties = new Properties();
         properties.load(new FileReader(filelocation));
         springBootApplication.setDefaultProperties(properties);**/

        SpringApplication.run(FinalprojectApplication.class, args);
    }
}
