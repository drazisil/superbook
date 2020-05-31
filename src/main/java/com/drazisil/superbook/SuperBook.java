package com.drazisil.superbook;

import com.drazisil.superbook.command.TabCompleteSuperBook;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.drazisil.superbook.command.CommandSuperBook;

public final class SuperBook extends JavaPlugin {

    public static final String MODID = "superbook";

    public static SuperBook plugin;
    public static Logger logger;
    private String booksConfigFilename = "books.yml";
    private File customConfigFile;
    private FileConfiguration booksConfig;
    private BookManager bookManager;

    @Override
    public void onEnable() {
        plugin = this;

        logger = plugin.getLogger();

        // Generate default config files
        plugin.saveDefaultConfig();
        plugin.saveBooksDefaultConfig();

        // Fetch books and populate the BookManager
        List<Map<?, ?>> books = plugin.getBooksConfig().getMapList("books");
        this.bookManager = new BookManager(books);

        // Register command handlers
        PluginCommand cmdSuperbook = plugin.getCommand("superbook");
        if (!(cmdSuperbook == null)) {
            cmdSuperbook.setExecutor(new CommandSuperBook());
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
        return this.booksConfig;
    }

    private void saveBooksDefaultConfig() {
        customConfigFile = new File(getDataFolder(), booksConfigFilename);
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource(booksConfigFilename, false);
        }

        booksConfig = new YamlConfiguration();
        try {
            booksConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
