package br.com.gerenciarvacinas.gerenciar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GerenciarApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenciarApplication.class, args);
    }

}
