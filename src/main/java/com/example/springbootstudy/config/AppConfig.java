package com.example.springbootstudy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.example.springbootstudy.*",lazyInit = true)
public class AppConfig {
}
