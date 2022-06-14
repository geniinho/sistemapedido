package com.geninho.ordempedido;

import com.geninho.ordempedido.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OrdempedidoApplication implements CommandLineRunner {

    @Autowired
    private S3Service s3Service;


    public static void main(String[] args) {
        SpringApplication.run(OrdempedidoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        s3Service.uploadFile("C:\\Users\\genii\\Downloads\\AVANADE\\3X4.jpg");
    }
}
