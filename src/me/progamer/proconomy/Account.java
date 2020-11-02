package me.progamer.proconomy;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Account implements Listener {
    Main main = new Main();

    public void firstJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!main.getAccountData().contains(player.getName())) {
            main.getAccountData().createSection(player.getName());
            main.getAccountData().set(player.getName() + ".balance", 0 );
        }
    }
}
