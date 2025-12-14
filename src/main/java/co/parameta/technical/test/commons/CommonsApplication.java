package co.parameta.technical.test.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Commons module of the Parameta Technical Test.
 * <p>
 * This application bootstraps shared configurations, entities, repositories,
 * services, and utilities used across REST and SOAP modules.
 */
@SpringBootApplication
public class CommonsApplication {

	/**
	 * Starts the Spring Boot application context for the Commons module.
	 *
	 * @param args application startup arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CommonsApplication.class, args);
	}

}
