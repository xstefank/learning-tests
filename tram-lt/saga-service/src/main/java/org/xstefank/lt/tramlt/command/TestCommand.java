package org.xstefank.lt.tramlt.command;

import io.eventuate.tram.commands.common.Command;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class TestCommand implements Command {

    private String name;

    public TestCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
