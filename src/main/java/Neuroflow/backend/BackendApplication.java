package Neuroflow.backend;

import Neuroflow.backend.config.DataBaseConfig;
import Neuroflow.backend.config.SecurityConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataBaseConfig.class, SecurityConfig.class})
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
}
