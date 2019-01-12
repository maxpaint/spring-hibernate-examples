package com.maxpaint.hibernate.statistic;

import com.maxpaint.hibernate.statistic.config.PostgreSqlConfig;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PostgreSqlConfig.class)
public class MainApplicationTest {

    @Test
    void contextLoads() {

    }


    /*public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                "spring.datasource.url=" + POSTGRESQL_CONTAINER.getJdbcUrl(),
                "spring.datasource.username=" + POSTGRESQL_CONTAINER.getUsername(),
                "spring.datasource.password=" + POSTGRESQL_CONTAINER.getPassword(),
                "spring.flyway.url=" + POSTGRESQL_CONTAINER.getJdbcUrl(),
                "spring.flyway.user=" + POSTGRESQL_CONTAINER.getUsername(),
                "spring.flyway.password="+ POSTGRESQL_CONTAINER.getPassword()
            );
            values.applyTo(configurableApplicationContext);
        }
    }*/

}