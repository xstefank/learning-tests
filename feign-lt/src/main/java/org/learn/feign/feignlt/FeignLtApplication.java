package org.learn.feign.feignlt;

import org.learn.feign.feignlt.feign.BookClient;
import org.learn.feign.feignlt.model.Book;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class FeignLtApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignLtApplication.class, args);

		BookControllerFeignClientBuilder feignClientBuilder = new BookControllerFeignClientBuilder();
		BookClient bookClient = feignClientBuilder.getBookClient();

		List<Book> books = bookClient.findAll()
				.stream()
				.collect(Collectors.toList());
		LoggerFactory.getLogger(FeignLtApplication.class).info("{}", books);
	}
}
