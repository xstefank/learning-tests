package org.acme;

import io.smallrye.mutiny.Multi;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/mutiny")
public class GreetingResource {

    private Multi<String> events = Multi.createFrom().items("A", "B", "C", "D");

    @GET
    @Path("/not-working")
    public void notWorking() {
        events
            .subscribe()
            .withSubscriber(
                new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("OnSubscription Method");
                        System.out.println("ON SUBS END");
                    }

                    @Override
                    public void onNext(String event) {
                        System.out.println("On Next Method");
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("OnError Method");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On Complete Method");
                    }
                });
    }

    @GET
    @Path("/working")
    public void working() {
        events
            .subscribe()
            .withSubscriber(
                new Subscriber<String>() {
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("OnSubscription Method");
                        System.out.println("ON SUBS END");
                        subscription = s;
                        subscription.request(1);
                    }

                    @Override
                    public void onNext(String event) {
                        System.out.println("On Next Method");
                        subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("OnError Method");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On Complete Method");
                    }
                });
    }

    @GET
    @Path("/working2")
    public void working2() {
        events
            .onSubscription()
                .invoke(() -> {
                    System.out.println("OnSubscription Method");
                    System.out.println("ON SUBS END");
                })
            .onItem()
                .invoke(event -> System.out.println("On Next Method"))
            .onFailure()
                .invoke(t -> System.out.println("OnError Method"))
            .onCompletion()
                .invoke(() -> System.out.println("On Complete Method"))
            .subscribe()
                .with(value -> {});
    }
}