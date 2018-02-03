package org.xstefank.lt;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
//        saveJSON();
        readJSON();
    }

    private static void saveJSON() throws IOException {
        Wrapper wrapper = new Wrapper<StringBuffer>("test wrapper", new StringBuffer("test data"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("test.json"), wrapper);
    }

    private static void readJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Wrapper wrapper = mapper.readValue(new File("test.json"), Wrapper.class);

        System.out.println(wrapper.getData().getClass());
    }

}
