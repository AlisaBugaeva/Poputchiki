package com.poputchiki;

import com.poputchiki.constants.PoputchikiProperties;
import com.poputchiki.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class PoputchikiRestApplication {

    private static Logger log = LoggerFactory.getLogger(PoputchikiRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PoputchikiRestApplication.class);
        log.info("An INFO Message: The program is working!");
    }
}
