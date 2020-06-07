package com.drazisil.superbook;

import com.drazisil.superbook.command.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        AbstractCommand cmd = new HelpCommand();

        // No args, show help.
        if (args.length == 0) {
            return cmd.execute(sender, args);
        }

        switch (args[0].toLowerCase()) {
            case "agree":
                // /superbook agree <book_key> <approval_code>
                // Agree requires at least two more args
                if (args.length <= 3) return false;
                cmd = new AgreeCommand();
                break;
            case "give":
                // /superbook give <book_key> [count]
                // /superbook give <player> <book_key> [count]
                // List requires at least 1 more arg
                if (args.length <= 2) return false;
                cmd = new GiveCommand();
                break;
            case "list":
                cmd = new ListCommand();
                break;
            case "reload":
                cmd = new ReloadCommand(sender);
                break;
        }

        return cmd.execute(sender, args);

    }

}
