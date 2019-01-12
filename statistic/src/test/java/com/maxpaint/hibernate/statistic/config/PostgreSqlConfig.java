package com.maxpaint.hibernate.statistic.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
public class PostgreSqlConfig implements ApplicationContextInitializer<ConfigurableApplicationContext>, DisposableBean {

    static final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:10.4")
            .withDatabaseName("statistic")
            .withUsername("postgres")
            .withPassword("postgres@123");


    static {
        postgreSQLContainer.start();
        // make sure that containers will be stop
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("DockerContainers stop");
            postgreSQLContainer.stop();
        }));
    }

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues values = TestPropertyValues.of(
            "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
            "spring.datasource.username=" + postgreSQLContainer.getUsername(),
            "spring.datasource.password=" + postgreSQLContainer.getPassword(),
            "spring.flyway.url=" + postgreSQLContainer.getJdbcUrl(),
            "spring.flyway.user=" + postgreSQLContainer.getUsername(),
            "spring.flyway.password="+ postgreSQLContainer.getPassword()
        );
        values.applyTo(configurableApplicationContext);
    }

    @Override
    public void destroy() {
        postgreSQLContainer.stop();
    }
}
