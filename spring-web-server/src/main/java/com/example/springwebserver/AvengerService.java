package com.example.springwebserver;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AvengerService {

    private final AtomicLong idCounter = new AtomicLong(0);

    private static final Map<Long, Avenger> avengers = new HashMap<>();

    @PostConstruct
    public void init() {
        createAvenger(new Avenger("Iron Man", "Tony Stark", false));
        createAvenger(new Avenger("Captain America", "Steve Rogers", false));
        createAvenger(new Avenger("Spider-man", "Peter Parker", true));
    }

    public Collection<Avenger> getAvengers() {
        return Collections.unmodifiableCollection(avengers.values());
    }

    public Avenger getAvengerById(Long id) {
        return avengers.get(id);
    }

    public void createAvenger(Avenger avenger) {
        avengers.put(idCounter.incrementAndGet(), avenger);
    }
}
