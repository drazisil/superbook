package com.drazisil.superbook;

import com.drazisil.superbook.command.TabCompleteSuperBook;
import org.bstats.bukkit.Metrics;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public final class SuperBook extends JavaPlugin {

    public static Logger logger;
    public static SuperBook plugin;

    private static FileConfiguration booksConfig;
    private static BookManager bookManager;
    private static File customConfigFile;
    private static Objective rulesObjective;
    private static Scoreboard scoreboard;

    @Override
    public void onEnable() {
        plugin = this;

        logger = plugin.getLogger();

        // Generate default config files
        plugin.saveDefaultConfig();
        plugin.saveBooksDefaultConfig();

        loadBooksConfig();

        // Register the scoreboard and objective
        ScoreboardManager scoreboardManager = getServer().getScoreboardManager();

        if (!(scoreboardManager == null)) {
            scoreboard = scoreboardManager.getMainScoreboard();
        } else {
            logger.severe("Unable to get default server scoreboard!");
        }

        rulesObjective = scoreboard.getObjective("rules_agreed");

        if (rulesObjective == null) {
            rulesObjective = scoreboard.registerNewObjective("rules_agreed","dummy", "rules_agreed");

        }


        // Register Event listeners
        getServer().getPluginManager().registerEvents(new EventListener(), plugin);

        int pluginId = 7829;
        new Metrics(this, pluginId);

        // Register command handlers
        PluginCommand cmdSuperbook = plugin.getCommand("superbook");
        if (!(cmdSuperbook == null)) {
            cmdSuperbook.setExecutor(new CommandHandler());
        } else {
            logger.severe("Unable to set command handler for superbook!");
        }

        // Register tab completion
        PluginCommand tabSuperbook = plugin.getCommand("superbook");
        if (!(tabSuperbook == null)) {
            tabSuperbook.setTabCompleter(new TabCompleteSuperBook());
        } else {
            logger.severe("Unable to set command handler for superbook!");
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getBooksConfig() {
        return booksConfig;
    }

    public static Objective getRulesObjective() {
        return rulesObjective;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public static void loadBooksConfig() {
        booksConfig = new YamlConfiguration();
        try {
            booksConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        // Fetch books and populate the BookManager
        List<Map<?, ?>> books = plugin.getBooksConfig().getMapList("books");
        bookManager = new BookManager(books);

    }

    @SuppressWarnings("unchecked")
    public static <T> T[] arrayPop(T[] var0) {
        if (var0.length <= 1) return var0;

        Object[] var1 = Arrays.copyOfRange(var0, 1, var0.length);

        return (T[]) var1;
    }

    private void saveBooksDefaultConfig() {
        String booksConfigFilename = "books.yml";
        customConfigFile = new File(getDataFolder(), booksConfigFilename);
        if (!customConfigFile.exists()) {
            try {
                saveResource(booksConfigFilename, false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (!customConfigFile.exists()) {
            throw new Error("Unable to locate " + booksConfigFilename + " after saving!");
        }
    }

}
