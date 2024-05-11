package com.york.pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Waiter {

    private final List<Command> commands = new ArrayList<Command>();

    public void setCommand(Command command) {
        this.commands.add(command);
    }

    public void notifyCommand() {
        commands.forEach(Command::execute);
    }
}
