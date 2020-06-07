package com.drazisil.superbook.command;

import com.drazisil.superbook.command.AbstractCommand;
import org.bukkit.command.CommandSender;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        return false;
    }
}
