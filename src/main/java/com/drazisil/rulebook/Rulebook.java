package com.drazisil.rulebook;

import com.google.common.base.Charsets;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public final class Rulebook extends JavaPlugin {

    public static Rulebook plugin;
    public static Logger logger;
    private String booksConfig = "books.yml";
    private File customConfigFile;
    private FileConfiguration customConfig;

    @Override
    public void onEnable() {
        plugin = this;

        logger = plugin.getLogger();

        plugin.saveDefaultConfig();

        plugin.createCustomConfig();

        List<Map<?, ?>> books = plugin.getCustomConfig().getMapList("books");

        BookManager bookManager = new BookManager(books);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), booksConfig);
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource(booksConfig, false);
        }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
