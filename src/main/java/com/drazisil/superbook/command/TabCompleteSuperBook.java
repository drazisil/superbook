package com.drazisil.superbook.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteSuperBook implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        ArrayList<String> options = new ArrayList<>();

        options.add("agree");
        options.add("give");
        options.add("list");

        return options;
    }
}
