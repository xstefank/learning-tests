package io.xstefank;

import rx.Subscription;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("subscribe")
public class SubscriptionResource {

    @GET
    @Path("exception")
    public void exception() {
        Subject<Integer, Integer> s = ReplaySubject.create();
        s.subscribe(
            v -> System.out.println(v),
            e -> System.err.println(e));
        s.onNext(0);
        s.onError(new Exception("Oops"));
    }

    @GET
    @Path("unsubscribe")
    public void unsubscribe() {
        Subject<Integer, Integer> values = ReplaySubject.create();
        Subscription subscription = values.subscribe(
            v -> System.out.println(v),
            e -> System.err.println(e),
            () -> System.out.println("Done")
        );
        values.onNext(0);
        values.onNext(1);
        subscription.unsubscribe();
        values.onNext(2);
    }

    @GET
    @Path("clean")
    public void clean() {
        Subscription s = Subscriptions.create(() -> System.out.println("clean"));
        s.unsubscribe();
        
    }
}
