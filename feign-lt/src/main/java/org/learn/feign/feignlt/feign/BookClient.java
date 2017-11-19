package org.learn.feign.feignlt.feign;

import feign.RequestLine;
import org.learn.feign.feignlt.model.Book;

import java.util.List;

public interface BookClient {

    @RequestLine("GET")
    List<Book> findAll();
}
