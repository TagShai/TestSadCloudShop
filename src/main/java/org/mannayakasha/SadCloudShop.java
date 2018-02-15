package org.mannayakasha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class, that contains method main() and launches the app.
 *
 * @author Pavel Milovidov
 * @version 1.0 25.10.2017.
 */

@SpringBootApplication
@ComponentScan
public class SadCloudShop extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SadCloudShop.class, args);
    }
}