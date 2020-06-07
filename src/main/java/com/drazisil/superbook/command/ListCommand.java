package com.drazisil.superbook.command;

import com.drazisil.superbook.SuperBook;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class ListCommand extends AbstractCommand {
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        sender.sendMessage("Listing books...");
        ArrayList<String> bookList = SuperBook.plugin.getBookManager().listBooks();
        for (String bookEntry: bookList) {
            sender.sendMessage(bookEntry);
        }
        return true;
    }
}
