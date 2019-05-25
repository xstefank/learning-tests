package io.xstefank;

import rx.schedulers.Schedulers;
import rx.subjects.AsyncSubject;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.ReplaySubject;
import rx.subjects.Subject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@Path("/ping")
public class PingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        PublishSubject<Integer> subject = PublishSubject.create();
        subject.onNext(1);
        subject.subscribe(System.out::println);
        subject.onNext(2);
        subject.onNext(3);
        subject.onNext(4);
        
        return "hello";
    }

    @GET
    @Path("replay")
    @Produces(MediaType.TEXT_PLAIN)
    public String replay() {

        ReplaySubject<Integer> subject = ReplaySubject.createWithSize(2);
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        subject.subscribe(System.out::println);
        subject.onNext(4);

        return "hello";
    }

    @GET
    @Path("replay-time")
    @Produces(MediaType.TEXT_PLAIN)
    public String replayTime() throws Exception {

        ReplaySubject<Integer> s = ReplaySubject.createWithTime(150, TimeUnit.MILLISECONDS,
            Schedulers.immediate());
        s.onNext(0);
        Thread.sleep(100);
        s.onNext(1);
        Thread.sleep(100);
        s.onNext(2);
        s.subscribe(v -> System.out.println("Late: " + v));
        s.onNext(3);

        return "hello";
    }

    @GET
    @Path("behavior")
    @Produces(MediaType.TEXT_PLAIN)
    public String behavior() throws Exception {

        BehaviorSubject<Integer> s = BehaviorSubject.create();
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
        s.subscribe(
            v -> System.out.println("Late: " + v),
            e -> System.out.println("Error"),
            () -> System.out.println("Completed")
        );

        return "hello";
    }

    @GET
    @Path("async")
    @Produces(MediaType.TEXT_PLAIN)
    public String async() throws Exception {

        AsyncSubject<Integer> s = AsyncSubject.create();
        s.subscribe(System.out::println);
        s.onNext(0);
        s.onNext(1);
        s.onNext(2);
        s.onCompleted();
        
        return "hello";
    }

    @GET
    @Path("after")
    @Produces(MediaType.TEXT_PLAIN)
    public String after() throws Exception {

        Subject<Integer, Integer> s = ReplaySubject.create();
        s.subscribe(v -> System.out.println(v));
        s.onNext(0);
        s.onCompleted();
        s.onNext(1);
        s.onNext(2);
        
        return "hello";
    }

}
