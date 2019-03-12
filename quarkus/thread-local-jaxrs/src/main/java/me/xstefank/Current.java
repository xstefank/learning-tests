package me.xstefank;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Current {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void set(String value) {
        threadLocal.set(value);
    }
    
    public String get() {
        return threadLocal.get();
    }
}
