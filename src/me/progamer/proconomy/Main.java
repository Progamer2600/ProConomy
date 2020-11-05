package me.progamer.proconomy;

import me.progamer.proconomy.commands.balance;
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
        getCommand("bal").setExecutor(new balance());
        getCommand("balance").setExecutor(new balance());
        getServer().getPluginManager().registerEvents(new Account(), this);
        createDataFolder();
        //System.out.println(playerAccounts.get);
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
           fileConfiguration = YamlConfiguration.loadConfiguration(playerAccounts);
           saveData();
        }
    }
    public void saveData() {
        try {
            fileConfiguration.save(playerAccounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadData() {

        if (playerAccounts.exists()) {
            fileConfiguration = YamlConfiguration.loadConfiguration(playerAccounts);
        } else {
            //fileConfiguration = YamlConfiguration.loadConfiguration(getResource("PlayerAccounts.yml"));
        }
    }

}
