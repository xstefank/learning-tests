package org.learn.eventuate.eventuatelt;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EventuateDriverConfiguration.class)
public class EventuateLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventuateLtApplication.class, args);
	}
}
