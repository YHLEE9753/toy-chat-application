package com.toy.chat.config;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public class MySqlContainerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Container
    public static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.26")
            .withDatabaseName("test-mysql")
            .withUsername("test")
            .withPassword("test");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        mysqlContainer.start();
    }
}