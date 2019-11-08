package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("test")
    public void test() {
        String s = "whatever";

        System.out.println(substrings(s, 5));
    }

    private List<String> substrings(String s, int length) {
        return new ArrayList<>(remove(s, s.length() - length));
    }

    private List<String> remove(String s, int toRemove) {
        if (toRemove == 0) {
            return Collections.singletonList(s);
        }
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            String substring = new StringBuilder(s).deleteCharAt(i).toString();
            result.addAll(remove(substring, toRemove - 1));
        }

        return result;
    }
}
