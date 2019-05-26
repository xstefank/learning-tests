package io.xstefank;

import rx.Observable;
import rx.Subscription;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("inspection")
public class InspectionResource {

    @GET
    @Path("all")
    public void all() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(0);
            o.onNext(10);
            o.onNext(10);
            o.onNext(2);
            o.onCompleted();
        });


        Subscription evenNumbers = values
            .all(i -> i % 2 == 0)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );

    }

    @GET
    @Path("empty")
    public void empty() {
        Observable<Integer> observable = Observable.empty();

        observable
            .isEmpty()
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }

    @GET
    @Path("defIfEmpty")
    public void defaultIfEmpty() {
        Observable<Integer> values = Observable.empty();

        Subscription subscription = values
            .defaultIfEmpty(2)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );


        Observable<Integer> values2 = Observable.error(new Exception());

        Subscription subscription2 = values2
            .defaultIfEmpty(2)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }

    @GET
    @Path("seqEqual")
    public void sequenceEqual() {

        Observable<String> strings = Observable.just("1", "2", "3");
        Observable<Integer> ints = Observable.just(1, 2, 3);

        Observable.sequenceEqual(strings, ints, (s, i) -> s.equals(i.toString()))
        //Observable.sequenceEqual(strings, ints)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
}
