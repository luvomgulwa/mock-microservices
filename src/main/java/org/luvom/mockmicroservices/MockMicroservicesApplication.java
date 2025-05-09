package org.luvom.mockmicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "org.luvom.mockmicroservices.repository")
public class MockMicroservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockMicroservicesApplication.class, args);
    }

}
