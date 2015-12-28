package br.com.finchsolucoes.lorem;

import br.com.finchsolucoes.lorem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by leodouglas on 23/12/15.
 */
@SpringBootApplication
@EnableEurekaClient
public class Application {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

