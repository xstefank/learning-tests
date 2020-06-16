package io.xstefank;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        AtomicInteger counter = new AtomicInteger(0);
        
        Uni<Integer> uni1 = Uni.createFrom().item(1);
        Uni<Integer> uni3 = Uni.createFrom().item(() -> counter.getAndIncrement());

        List<Uni<Integer>> unis = List.of(uni1, uni3);

        Uni<Integer> integerUni = Uni.combine().all().unis(unis)
            .combinedWith(results ->
            {
                System.out.println(results);
                System.out.println("=====================");
                return 0;
            }).onFailure().recoverWithItem(-1);

        System.out.println(integerUni.await().indefinitely());
        System.out.println(integerUni.await().indefinitely());
        System.out.println(integerUni.await().indefinitely());
        
        return "hello";
    }
}
