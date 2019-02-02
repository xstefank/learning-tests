package org.xstefank;

public interface Dummy {
    
    default void whatever() {
        System.out.println(getWhatever());
    }

    private String getWhatever() {
        return "Whatever";
    }
}
