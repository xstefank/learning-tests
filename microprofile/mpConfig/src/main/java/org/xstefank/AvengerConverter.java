package org.xstefank;

import org.eclipse.microprofile.config.spi.Converter;

public class AvengerConverter implements Converter<Avenger> {
    @Override
    public Avenger convert(String value) {
        String[] split = value.split("\\|");
        return Avenger.name(split[0])
                .realName(split[1])
                .alive(Boolean.valueOf(split[2]))
                .build();
    }
}
