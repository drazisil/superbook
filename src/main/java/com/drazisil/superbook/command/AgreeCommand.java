package com.drazisil.superbook.command;

import com.drazisil.superbook.BookSuperBook;
import com.drazisil.superbook.SuperBook;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static com.drazisil.superbook.SuperBook.getRulesObjective;

public class AgreeCommand extends AbstractCommand {
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        System.out.println(Arrays.toString(args));
        if (sender instanceof Player && sender.hasPermission("superbook.agree")) {

            String bookKey = args[1];
            String approvalCode = args[2];

            BookSuperBook bookSource = SuperBook.plugin.getBookManager().getBookByKey(bookKey);

            if (!(bookSource.getApprovalCode().equals(approvalCode))) {
                sender.sendMessage("That code is not correct, sorry.");
                return true;
            }

            Server server = sender.getServer();

            ConsoleCommandSender console = sender.getServer().getConsoleSender();

            server.dispatchCommand(console, "lp user " + sender.getName() + " promote players");
            getRulesObjective().getScore(sender.getName()).setScore(1);

            sender.sendMessage("You agreed!");

            return true;
        }
        return true;
    }
}
