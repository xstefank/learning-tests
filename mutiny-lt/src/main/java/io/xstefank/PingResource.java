package io.xstefank;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        Uni<Integer> uni1 = Uni.createFrom().item(1);
        Uni<Integer> uni2 = Uni.createFrom().failure(() -> new Exception());
        Uni<Integer> uni3 = Uni.createFrom().item(3);

        List<Uni<Integer>> unis = List.of(uni1, uni2, uni3);

        Uni<Integer> integerUni = Uni.combine().all().unis(unis)
            .combinedWith(results ->
            {
                results.forEach(System.out::println);
                return 0;
            }).onFailure().recoverWithItem(-1);

        System.out.println(integerUni.await().indefinitely());
        return "hello";
    }
}
