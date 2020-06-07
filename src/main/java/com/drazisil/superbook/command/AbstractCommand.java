package com.drazisil.superbook.command;

import org.bukkit.command.CommandSender;

public abstract class AbstractCommand {

    public boolean hasMinArgs(int argCount) {
        return argCount >= minArgs;
    }

    protected int minArgs = 0;

    public AbstractCommand() {
    }

    public abstract boolean execute(CommandSender sender, String[] args);

}
