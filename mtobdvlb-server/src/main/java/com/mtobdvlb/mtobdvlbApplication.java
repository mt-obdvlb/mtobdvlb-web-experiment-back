package com.mtobdvlb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class mtobdvlbApplication
{
    public static void main( String[] args ) {
        SpringApplication.run(mtobdvlbApplication.class, args);
        log.info("server started");
    }
}
