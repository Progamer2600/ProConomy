package me.progamer.proconomy;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private File playerAccounts;
    private FileConfiguration fileConfiguration;

    @Override
    public void onEnable() {
        createDataFolder();
        getServer().getPluginManager().registerEvents(new Account(), this);
    }

    @Override
    public void onDisable() {

    }
    public FileConfiguration getAccountData() {
        return this.fileConfiguration;
    }

    private void createDataFolder() {
        playerAccounts = new File(getDataFolder(), "PlayerAccounts.yml");

        if (!playerAccounts.exists()) {
            playerAccounts.getParentFile().mkdirs();
            saveResource("PlayerAccounts.yml", false);
        }
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(playerAccounts);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
