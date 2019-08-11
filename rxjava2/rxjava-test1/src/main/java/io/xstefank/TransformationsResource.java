package io.xstefank;

import rx.Observable;
import rx.Subscriber;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("transformations")
public class TransformationsResource {

    @GET
    @Path("cast")
    public void cast() {
        Observable<Object> values = Observable.just(0, 1, 2, 3);
//        Observable<Object> values = Observable.just(0, 1, 2, "3");

        values
            .cast(Integer.class)
            .subscribe(new PrintSubscriber("Map"));
    }
    
    @GET
    @Path("ofType")
    public void ofType() {
        Observable<Object> values = Observable.just(0, 1, "2", 3);

        values
            .ofType(Integer.class)
            .subscribe(new PrintSubscriber("Map"));
    }
    
    @GET
    @Path("timestamp")
    public void timestamp() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values.take(3)
            .timestamp()
            .subscribe(new PrintSubscriber("Timestamp"));
    }
    
    @GET
    @Path("timeInterval")
    public void timeInterval() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values.take(3)
            .timeInterval()
            .subscribe(new PrintSubscriber("TimeInterval"));
    }

    @GET
    @Path("materialize")
    public void materialize() {
        Observable<Long> values = Observable.interval(100, TimeUnit.MILLISECONDS);

        values.take(3)
            .materialize()
            .subscribe(new PrintSubscriber("Materialize"));
    }
    
    @GET
    @Path("flatMap")
    public void flatMap() {
        Observable<Integer> values = Observable.just(2);

        values
            .flatMap(i -> Observable.range(0,i))
            .subscribe(new PrintSubscriber("flatMap"));
    }
    
    @GET
    @Path("flatMap2")
    public void flatMap2() {
        Observable<Integer> values = Observable.range(1,3);

        values
            .flatMap(i -> Observable.range(0,i))
            .subscribe(new PrintSubscriber("flatMap"));
    }
    
    @GET
    @Path("flatMap3")
    public void flatMap3() {
        Observable<Integer> values = Observable.range(0,30);

        values
            .flatMap(i -> {
                if (0 < i && i <= 26)
                    return Observable.just(Character.valueOf((char)(i+64)));
                else
                    return Observable.empty();
            })
            .subscribe(new PrintSubscriber("flatMap"));
    }
    
    @GET
    @Path("flatMap4")
    public void flatMap4() {
        Observable.just(100, 150)
            .flatMap(i ->
                Observable.interval(i, TimeUnit.MILLISECONDS)
                    .map(v -> i)
            )
            .take(10)
            .subscribe(new PrintSubscriber("flatMap"));
    }
    
    @GET
    @Path("concatMap")
    public void concatMap() {
        Observable.just(100, 150)
            .concatMap(i ->
                Observable.interval(i, TimeUnit.MILLISECONDS)
                    .map(v -> i)
                    .take(3))
            .subscribe(new PrintSubscriber("concatMap"));
    }

    @GET
    @Path("flatMapIterable")
    public void flatMapIterable() {
        Observable.range(1, 3)
            .flatMapIterable(i -> range(1, i))
            .subscribe(System.out::println);
    }
    
    private static Iterable<Integer> range(int start, int count) {
        List<Integer> list = new ArrayList<>();
        for (int i=start ; i<start+count ; i++) {
            list.add(i);
        }
        return list;
    }
    
    @GET
    @Path("flatMapIterable2")
    public void flatMapIterable2() {
        Observable.range(1, 3)
            .flatMapIterable(
                i -> new Range(1, i),
                (ori, rv) -> ori * (Integer) rv)
            .subscribe(System.out::println);
    }

    public static class Range implements Iterable<Integer> {

        private static class RangeIterator implements Iterator<Integer> {

            private int next;
            private final int end;

            RangeIterator(int start, int count) {
                this.next = start;
                this.end = start + count;
            }

            @Override
            public boolean hasNext() {
                return next < end;
            }

            @Override
            public Integer next() {
                return next++;
            }

        }

        private final int start;
        private final int count;

        public Range(int start, int count) {
            this.start = start;
            this.count = count;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new RangeIterator(start, count);
        }

    }

    
}
