package io.xstefank;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@Path("sequence")
public class SequenceResource {

    @GET
    @Path("just")
    public void just() {
        Observable<String> values = Observable.just("one", "two", "three");
        Subscription subscription = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );
    }

    @GET
    @Path("defer")
    public void defer() throws Exception {
        Observable<Long> now = Observable.defer(() ->
            Observable.just(System.currentTimeMillis()));

        now.subscribe(System.out::println);
        Thread.sleep(1000);
        now.subscribe(System.out::println);
    }
    
    @GET
    @Path("create")
    public void create() {
        Observable<String> values = Observable.create(o -> {
            o.onNext("Hello");
            o.onCompleted();
        });
        Subscription subscription = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );
    }
    
    @GET
    @Path("interval")
    public void interval() throws Exception {
        Observable<Long> values = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Subscription s = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        s.unsubscribe();
    }
    
    @GET
    @Path("timer")
    public void timer() {
        Observable<Long> values = Observable.timer(1, TimeUnit.SECONDS);
        Subscription subscription = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );
    }
    
    @GET
    @Path("timer2")
    public void timer2() {
        Observable<Long> values = Observable.timer(2, 1, TimeUnit.SECONDS);
        Subscription subscription = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        subscription.unsubscribe();
    }
    
    @GET
    @Path("future")
    public void future() {
        FutureTask<Integer> f = new FutureTask<Integer>(() -> {
            Thread.sleep(2000);
            return 21;
        });
        new Thread(f).start();

        Observable<Integer> values = Observable.from(f, 1, TimeUnit.SECONDS);

        Subscription subscription = values.subscribe(
            v -> System.out.println("Received: " + v),
            e -> System.out.println("Error: " + e),
            () -> System.out.println("Completed")
        );
    }
    
    @GET
    @Path("array")
    public void array() {
        Integer[] is = {1,2,3};
        Observable<Integer> values = Observable.from(is);
        Subscription subscription = values.subscribe(soutSubscriber);
    }
    
    @GET
    @Path("range")
    public void range() {
        Observable<Integer> values = Observable.range(10, 15);
        values.subscribe(soutSubscriber);
    }
    
    private Subscriber<Integer> soutSubscriber = new Subscriber<Integer>() {
        @Override
        public void onCompleted() {
            System.out.println("Completed");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("Error: " + e);
        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("Received: " + integer);
        }
    };
}
