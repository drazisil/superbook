package com.drazisil.superbook.command;

import com.drazisil.superbook.BookSuperBook;
import com.drazisil.superbook.SuperBook;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

import static java.lang.Integer.parseInt;

public class GiveCommand extends AbstractCommand {

    public GiveCommand() {
        this.minArgs = 1;
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {

        if (!(hasMinArgs(args.length))) return false;

        Player playerToGive;

        // /superbook give <book_key> [count]
        // /superbook give <player> <book_key> [count]

        // Was a player specified?
        playerToGive = sender.getServer().getPlayer(args[1]);
        if (playerToGive == null) {

            // If no player was given, check that the command was not run by console
            if (!(sender instanceof Player)) {
                sender.sendMessage("I'm sorry, you need to provide a player.");
                return false;
            }

            playerToGive = (Player) sender;

        } else {
            args = SuperBook.arrayPop(args);
        }

        // Is this a valid book?
        if (SuperBook.plugin.getBookManager().getBookByKey(args[1]) == null) return false;

        String bookKey = args[1];

        int bookCount = 1;

        if (args.length >= 3) {
            try {
                bookCount = parseInt(args[2]);
            } catch (NumberFormatException ignored) {
            }
        }

        giveBook(sender, playerToGive, bookKey, bookCount);

        System.out.printf("%s, %s, %s, %d%n",sender, playerToGive, bookKey, bookCount);

        return true;
    }

    private void giveBook(CommandSender sender, Player player, String bookKey, int count) {

        BookSuperBook bookSource = SuperBook.plugin.getBookManager().getBookByKey(bookKey);

        ItemStack newBook = new ItemStack(Material.WRITTEN_BOOK, count);
        BookMeta bookMeta = (BookMeta) newBook.getItemMeta();

        // TODO: Create the book

        bookMeta.setTitle(bookSource.getName());
        bookMeta.setAuthor("Neverland Staff");

        //create a page
        BaseComponent[] page = new ComponentBuilder("Click me")
                .event(new ClickEvent(ClickEvent.Action.OPEN_URL, "http://spigotmc.org"))
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Go to the spigot website!").create()))
                .create();

        //add the page to the meta
        bookMeta.spigot().addPage(page);

        newBook.setItemMeta(bookMeta);

        // Give the completed book
        PlayerInventory playerInventory = player.getInventory();
        if (!(playerInventory.firstEmpty() == -1)) {
            playerInventory.addItem(newBook);
        } else {
            sender.sendMessage(String.format("There is no room in %s's inventory for this book!",
                    player.getName()));
        }
    }
}
