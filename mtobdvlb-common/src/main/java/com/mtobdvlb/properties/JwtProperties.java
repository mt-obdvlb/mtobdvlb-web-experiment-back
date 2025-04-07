package com.mtobdvlb.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mtobdvlb.jwt")
@Data
public class JwtProperties {
    private String secret;
    private Long ttl;
    private String tokenName;

}
