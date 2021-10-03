package io.xstefank;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Closeable;
import java.io.IOException;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try (MyCloseable myCloseable = new MyCloseable();
             MyAutoCloseable myAutoCloseable = new MyAutoCloseable()) {
            System.out.println("in try");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Hello RESTEasy";
    }

    private class MyCloseable implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("Closeable closed");
        }
    }

    private class MyAutoCloseable implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("AutoCloseable close");
        }
    }
}
