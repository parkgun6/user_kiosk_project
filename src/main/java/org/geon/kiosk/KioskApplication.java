package org.geon.kiosk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KioskApplication {

    public static void main(String[] args) {
        SpringApplication.run(KioskApplication.class, args);
    }

}
