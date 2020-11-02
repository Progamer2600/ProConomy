package me.progamer.proconomy;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Account implements Listener {
   private Main main = Main.getPlugin(Main.class);

   @EventHandler
    public void firstJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!main.getAccountData().contains(player.getName())) {
            main.getAccountData().createSection(player.getName());
            main.getAccountData().set(player.getName() + ".balance", 0 );
            main.saveData();
        } else {
            return;
        }
    }
}
