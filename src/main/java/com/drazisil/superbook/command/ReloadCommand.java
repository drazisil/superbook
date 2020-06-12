package com.drazisil.superbook.command;

import com.drazisil.superbook.SuperBook;
import com.drazisil.superbook.command.AbstractCommand;
import org.bukkit.command.CommandSender;

public class ReloadCommand extends AbstractCommand {

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage(SuperBook.arrayPop(args));
        return true;
    }
}
