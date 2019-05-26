package io.xstefank;

import rx.Observable;
import rx.Subscription;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.TimeUnit;

@Path("operator")
public class OperatorsResource {
    
    @GET
    @Path("filter")
    public void filter() {
        Observable<Integer> values = Observable.range(0,10);
        Subscription oddNumbers = values
            .filter(v -> v % 2 == 0)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
    
    @GET
    @Path("distinct")
    public void distinct() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("First");
            o.onNext("Second");
            o.onNext("Third");
            o.onNext("Fourth");
            o.onNext("Fifth");
            o.onCompleted();
        });

        Subscription subscription = values
            .distinct(v -> v.charAt(0))
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
    
    @GET
    @Path("duc")
    public void distinctUntilChanged() {
        Observable<Integer> values = Observable.create(o -> {
            o.onNext(1);
            o.onNext(1);
            o.onNext(2);
            o.onNext(3);
            o.onNext(2);
            o.onCompleted();
        });

        Subscription subscription = values
            .distinctUntilChanged()
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
    
    @GET
    @Path("take")
    public void take() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        Subscription subscription = values
            .take(250, TimeUnit.MILLISECONDS)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
    
    @GET
    @Path("takeUntil")
    public void takeUntil() {
        Observable<Long> values = Observable.interval(100,TimeUnit.MILLISECONDS);
        Observable<Long> cutoff = Observable.timer(250, TimeUnit.MILLISECONDS);

        Subscription subscription = values
            .takeUntil(cutoff)
            .subscribe(
                v -> System.out.println(v),
                e -> System.out.println("Error: " + e),
                () -> System.out.println("Completed")
            );
    }
}
