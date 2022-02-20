package com.poputchiki.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "poputchiki.token")
@Getter
@Setter
public class PoputchikiProperties {

    private int expire;

}
