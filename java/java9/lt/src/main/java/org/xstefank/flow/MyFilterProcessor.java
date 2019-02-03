package org.xstefank.flow;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

public class MyFilterProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {

    private Predicate<T> predicate;
    private Subscription subscription;

    public MyFilterProcessor(Predicate<T> function) {
        super();
        this.predicate = function;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        if (predicate.test(item)) {
            submit(item);
        }
        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onComplete() {
        close();
    }
}  

