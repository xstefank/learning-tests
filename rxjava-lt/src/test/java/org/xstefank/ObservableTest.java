package org.xstefank;

import io.reactivex.Observable;
import junit.framework.TestCase;
import org.junit.Test;

public class ObservableTest extends TestCase {

    private String result = "";
    
    @Test
    public void testReturnValue() {
        result = "";
        Observable<String> observable = Observable.just("Hello");
        observable.subscribe(s -> result = s);
        assertTrue(result.equals("Hello"));
    }
    
}
