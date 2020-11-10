package me.progamer.proconomy;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class AccountData {
   private final Main main = Main.getPlugin(Main.class);
   private final Configuration config = main.getConfig();

    public int getBalance(Player player) {
        String playerName = player.getName();

        return config.getInt(playerName + ".balance");
    }
    public void setBalance(Player player, int balance) {
      String playerName = player.getName();

      config.set(playerName + ".balance", balance);
      main.saveConfig();
    }
}
