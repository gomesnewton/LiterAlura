package com.gomesnewton.LiterAlura;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gomesnewton.LiterAlura.application.StartApplication;
import com.gomesnewton.LiterAlura.resources.GutenDexApi;
import com.gomesnewton.LiterAlura.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

    @Autowired
    StartApplication startApplication;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        startApplication.start();
    }
}
