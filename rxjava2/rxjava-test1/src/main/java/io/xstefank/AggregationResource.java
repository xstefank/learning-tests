package io.xstefank;

import rx.Observable;
import rx.Subscriber;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.TimeUnit;

@Path("aggregate")
public class AggregationResource {

    @GET
    @Path("count")
    @SuppressWarnings("unchecked")
    public void count() {
        Observable<Integer> values = Observable.range(0, 3);

        values
            .subscribe(new PrintSubscriber("Values"));
        values
            .count()
            .subscribe(new PrintSubscriber("Count"));

    }
    
    @GET
    @Path("single")
    public void single() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values.take(10)
            .single(v -> v == 5L) // Emits a result
            .subscribe(new PrintSubscriber("Single1"));
        values
            .single(v -> v == 5L) // Never emits
            .subscribe(new PrintSubscriber("Single2"));
    }
    
    @GET
    @Path("reduce")
    public void reduce() {
        Observable<Integer> values = Observable.range(0,5);

        values
            .reduce((i1,i2) -> i1+i2)
            .subscribe(new PrintSubscriber("Sum"));
        values
            .reduce((i1,i2) -> (i1>i2) ? i2 : i1)
            .subscribe(new PrintSubscriber("Min"));
    }
    
    @GET
    @Path("scan")
    public void scan() {
        Observable<Integer> values = Observable.range(0,5);

        values
            .scan((i1,i2) -> i1+i2)
            .subscribe(new PrintSubscriber("Sum"));
    }
    
    private class PrintSubscriber extends Subscriber {
        private final String name;

        public PrintSubscriber(String name) {
            this.name = name;
        }

        @Override
        public void onCompleted() {
            System.out.println(name + ": Completed");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println(name + ": Error: " + e);
        }

        @Override
        public void onNext(Object v) {
            System.out.println(name + ": " + v);
        }
    }
}
