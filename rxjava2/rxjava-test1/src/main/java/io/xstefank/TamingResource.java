package io.xstefank;

import rx.Observable;
import rx.Subscription;
import rx.subjects.ReplaySubject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("taming")
public class TamingResource {
    
    @GET
    @Path("scan")
    public void scan() {
        Observable<String> values = Observable.just("No", "side", "effects", "please");

        Observable<Indexed<String>> indexed =
            values.scan(
                new Indexed<String>(0, null),
                (prev,v) -> new Indexed<String>(prev.index+1, v))
                .skip(1);
        indexed.subscribe(w -> System.out.println("1st observer: " + w.index + ": " + w.item));
        indexed.subscribe(w -> System.out.println("2nd observer: " + w.index + ": " + w.item));
    }
    
    @GET
    @Path("doOn")
    public void doOn() {
        Observable<String> values = Observable.just("side", "effects");

        values
            .doOnEach(new PrintSubscriber("Log"))
            .map(s -> ((String) s).toUpperCase())
            .subscribe(new PrintSubscriber("Process"));
    }

    @GET
    @Path("doOn2")
    public void doOn2() {
        service()
            .map(s -> s.toUpperCase())
            .filter(s -> s.length() > 5)
            .subscribe(new PrintSubscriber("Process"));
    }
    
    @GET
    @Path("doOn3")
    public void doOn3() {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        Observable<Integer> values = subject
            .doOnSubscribe(() -> System.out.println("New subscription"))
            .doOnUnsubscribe(() -> System.out.println("Subscription over"));

        Subscription s1 = values.subscribe(new PrintSubscriber("1st"));
        subject.onNext(0);
        Subscription s2 = values.subscribe(new PrintSubscriber("2st"));
        subject.onNext(1);
        s1.unsubscribe();
        subject.onNext(2);
        subject.onNext(3);
        subject.onCompleted();
    }
    
    static Observable<String> service() {
        return	Observable.just("First", "Second", "Third")
            .doOnEach(new PrintSubscriber("Log"));
    }
    
    private static class Indexed<T> {
        final int index;
        final T item;

        public Indexed(int index, T item) {
            this.index = index;
            this.item = item;
        }
    }
}
