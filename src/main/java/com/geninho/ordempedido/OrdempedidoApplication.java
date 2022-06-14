package com.geninho.ordempedido;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OrdempedidoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(OrdempedidoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
