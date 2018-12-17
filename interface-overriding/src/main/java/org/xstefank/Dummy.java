package org.xstefank;

public interface Dummy {
    
    default String getFoo() {
        return "foo";
    }
    
    String getBar();
}
