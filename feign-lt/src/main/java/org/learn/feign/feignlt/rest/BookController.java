package org.learn.feign.feignlt.rest;

import org.learn.feign.feignlt.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @GetMapping("/books")
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book("isbn1", "author1", "title1", "synopsis1", "lang1"),
                new Book("isbn2", "author2", "title2", "synopsis2", "lang2"));
    }
}
