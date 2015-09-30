package com.onestopcare;

import com.onestopcare.config.SessionReplicationAwareScopeMetadataResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(scopeResolver = SessionReplicationAwareScopeMetadataResolver.class)
public class OnestopcareApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnestopcareApplication.class, args);
    }
}
