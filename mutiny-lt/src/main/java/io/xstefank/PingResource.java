package io.xstefank;

import io.smallrye.mutiny.Uni;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.smallrye.mutiny.unchecked.Unchecked.function;

@Path("/ping")
public class PingResource {

    AtomicInteger counter = new AtomicInteger(0);


    @GET
    public void get() {
        String result1 = Uni.createFrom().item("testing")
            .onItem().transform(function(in -> {
                if (in.equals("test")) {
                    throw new Exception("in is test");
                }

                return in;
            }))
            .await().indefinitely();
        System.out.println(result1);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        Uni<Integer> uni1 = Uni.createFrom().item(1);
//        Uni<Integer> uni3 = Uni.createFrom().item(counter.getAndIncrement());
        Uni<Integer> deffered = Uni.createFrom().deferred(() -> call()).onFailure().recoverWithItem(50);
        Uni<Integer> nullUni = Uni.createFrom().item(() -> (Integer) null)
            .onItem().ifNull().continueWith(42);

        List<Uni<Integer>> unis = List.of(uni1, deffered, nullUni);

        Uni<Integer> integerUni = Uni.combine().all().unis(unis)
            .combinedWith(results ->
            {
                System.out.println(results);
                System.out.println("=====================");
                return 0;
            }).onFailure().recoverWithItem(-1);

        System.out.println(deffered.await().indefinitely());
        System.out.println(integerUni.await().indefinitely());
        System.out.println(integerUni.await().indefinitely());
        System.out.println(integerUni.await().indefinitely());

        return "hello";
    }

    private Uni<Integer> call() {
//        return Uni.createFrom().item(counter.getAndIncrement());
        return null;
    }
}
