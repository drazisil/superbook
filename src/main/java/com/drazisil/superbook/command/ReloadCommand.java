package com.drazisil.superbook.command;

import com.drazisil.superbook.SuperBook;
import com.drazisil.superbook.command.AbstractCommand;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends AbstractCommand {

    @Override
    public boolean execute(CommandSender sender, String[] args) {

        // TODO: Check for permissions
        SuperBook.loadBooksConfig();
        sender.sendMessage("Configuration reloaded");
        return true;
    }
}
