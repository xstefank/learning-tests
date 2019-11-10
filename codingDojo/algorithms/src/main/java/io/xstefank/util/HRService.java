package io.xstefank.util;

import javax.enterprise.context.ApplicationScoped;
import java.io.InputStream;
import java.util.Objects;

@ApplicationScoped
public class HRService {

    
    public InputStream getStream(String fileName) {
        return Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("hr/" + fileName));
    }
    
}
