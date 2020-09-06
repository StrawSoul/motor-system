package com.motor.system.server.application;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.motor.system.server")
@ImportResource(locations = { "classpath*:/spring/*.xml"})
@EnableAutoConfiguration
@MapperScan("com.motor.system.server.mapper")
@EnableCaching
@EnableTransactionManagement
public class MotorSystemServer {
    static Logger logger = LoggerFactory.getLogger(MotorSystemServer.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MotorSystemServer.class, args);
        logger.info("MotorSystemServer start up !!!");
    }
}
