package io.xstefank;

import rx.Subscriber;

public class PrintSubscriber extends Subscriber {
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
