package io.xstefank;

import org.eclipse.microprofile.metrics.annotation.ConcurrentGauge;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.CountDownLatch;

@Path("/")
public class PingResource {

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    @GET
    @Path("/parallel")
    @ConcurrentGauge(name = "parallelAccess", description = "Number of parallel accesses")
    public void parallelAccess() throws InterruptedException {
        countDownLatch.await();
        System.out.println("DONE");
    }

    @GET
    @Path("/parallel-finish")
    public void parallelFinish() {
        countDownLatch.countDown();
    }
}
