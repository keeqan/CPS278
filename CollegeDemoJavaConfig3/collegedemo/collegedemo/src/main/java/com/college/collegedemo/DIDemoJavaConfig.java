package com.college.collegedemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.college.collegedemo")
@PropertySource("classpath:college.properties")
public class DIDemoJavaConfig {
    
}
