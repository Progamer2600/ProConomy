package me.progamer.proconomy;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Account implements Listener {
   private final Main main = Main.getPlugin(Main.class);
   private final Configuration config = main.getConfig();

   @EventHandler
    public void firstJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        if (!config.contains(playerName)) {
            System.out.println("Pass");
            config.set(playerName + ".balance", 0 );
        } else {
            System.out.println("Psasaasaaass");

        }
    }
}
