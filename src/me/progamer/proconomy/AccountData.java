package me.progamer.proconomy;

import org.bukkit.entity.Player;

public class AccountData {
   private Main main = Main.getPlugin(Main.class);
    public int getBalance(Player player) {
        return main.getAccountData().getInt(player.getName() + ".balance");
    }
    public void setBalance(Player player, int balance) {
        main.getAccountData().set(player.getName() + ".balance", balance);
        main.saveData();

    }
}
