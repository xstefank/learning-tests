package org.xstefank.lt;

import org.jboss.logging.Logger;
import org.xstefank.lt.model.ParamDummy;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Provider
@ParamConverter.Lazy
public class DummyParamConverterProvider implements ParamConverterProvider {

    private static final Logger log = Logger.getLogger(DummyParamConverterProvider.class);

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.getName().equals(ParamDummy.class.getName())) {
            return new ParamConverter<T>() {
                @Override
                public T fromString(String value) {
                    log.info("fromString() invoked for " + value);
                    Pattern pattern = Pattern.compile("Dummy\\{name=(.*?),age=(.*?)}");
                    Matcher matcher = pattern.matcher(value);
                    if (matcher.find()) {
                        ParamDummy dummy = new ParamDummy();
                        dummy.setName(matcher.group(1));
                        dummy.setAge(Integer.parseInt(matcher.group(2)));
                        return (T) dummy;
                    }

                    return null;
                }

                @Override
                public String toString(T value) {
                    log.info("toString() invoked for " + value);
                    ParamDummy dummy = (ParamDummy) value;
                    return String.format("Dummy{name=%s,age=%d}", dummy.getName(), dummy.getAge());
                }
            };
        }

        return null;
    }
}
