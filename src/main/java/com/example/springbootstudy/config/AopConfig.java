package com.example.springbootstudy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.springbootstudy.*")
@EnableAspectJAutoProxy
public class AopConfig {
}
