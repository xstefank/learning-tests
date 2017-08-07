package org.learn;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
@ApplicationScoped
public class FooService {

    String sayFoo(String name) {
        return name + " foo!!";
    }

}
