package me.progamer.proconomy;

import me.progamer.proconomy.commands.balance;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {



    @Override
    public void onEnable() {
        getCommand("bal").setExecutor(new balance());
        getCommand("balance").setExecutor(new balance());
        getServer().getPluginManager().registerEvents(new Account(), this);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }


    @Override
    public void onDisable() {
        saveConfig();
    }

}
