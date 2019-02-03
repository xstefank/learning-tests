package org.xstefank.flow;

import java.util.Arrays;
import java.util.concurrent.SubmissionPublisher;

public class FlowMain {

    public static void main(String[] args) {
//        simplePublish();
        //Create Publisher  
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Create Processor and Subscriber  
        MyFilterProcessor<String> filterProcessor = new MyFilterProcessor<>(s -> !s.equals("x"));

        MyTransformProcessor<String, Integer> transformProcessor = new MyTransformProcessor<>(s -> Integer.parseInt(s));

        MySubscriber<Integer> subscriber = new MySubscriber<>();

        //Chain Processor and Subscriber  
        publisher.subscribe(filterProcessor);
        filterProcessor.subscribe(transformProcessor);
        transformProcessor.subscribe(subscriber);

        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.stream(items).forEach(i -> publisher.submit(i));
        publisher.close();
    }

    private static void simplePublish() {
        //Create Publisher  
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        //Register Subscriber  
        MySubscriber<String> subscriber = new MySubscriber<>();
        publisher.subscribe(subscriber);

        //Publish items  
        System.out.println("Publishing Items...");
        String[] items = {"1", "x", "2", "x", "3", "x"};
        Arrays.stream(items).forEach(i -> publisher.submit(i));
        publisher.close();
    }
}
