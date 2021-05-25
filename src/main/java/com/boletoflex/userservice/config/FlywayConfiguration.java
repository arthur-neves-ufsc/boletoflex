package com.boletoflex.userservice.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class FlywayConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlywayConfiguration.class);
    private static final int MAX_ATTEMPTS = 10;
    private final String url;
    private final String username;
    private final String password;

    @Autowired
    private DataSource dataSource;

    public FlywayConfiguration(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void migration() throws InterruptedException {
        checkDatabaseConnection();
        Flyway flyway = Flyway.configure()
        	.dataSource(url, username, password)
        	.baselineVersion("1")
        	.baselineOnMigrate(true)
        	.locations("classpath:db/migration")
        	.load();
        
        flyway.migrate();
        flyway.validate();
    }

    private void checkDatabaseConnection() throws InterruptedException {
        int count = 1;
        while (true) {
            try (Connection ignored = dataSource.getConnection()) {
                break;
            } catch (SQLException e) {
                LOGGER.error("Unable to connect to database... Attempt number: " + count);
                if (count++ == MAX_ATTEMPTS) {
                    LOGGER.error("###############################################################################################");
                    LOGGER.error("# Max numbers of attempts reached. Please check your MySQL database connection and try again. #");
                    LOGGER.error("###############################################################################################");
                    LOGGER.error("Could not connect to database: ", e);
                    System.exit(0);
                }
                Thread.sleep(10000);
            }
        }
    }

}
