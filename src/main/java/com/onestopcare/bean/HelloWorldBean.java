package com.onestopcare.bean;

import com.onestopcare.config.ScopeName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Bazlur Rahman Rokon
 * @date 9/30/15.
 */
@Component
@Scope(ScopeName.VIEW)
public class HelloWorldBean implements Serializable {

    public String hello() {
        return "Hello world from Server. Time now: "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
