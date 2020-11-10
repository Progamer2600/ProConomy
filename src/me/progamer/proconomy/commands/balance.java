package me.progamer.proconomy.commands;

import me.progamer.proconomy.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;


public class balance implements CommandExecutor {
    private final Main main = Main.getPlugin(Main.class);
    private final Configuration config = main.getConfig();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        String playerName = player.getName();
        String playerBalance = playerName + ".balance";

        if (command.getName().equalsIgnoreCase("bal") || command.getName().equalsIgnoreCase("balance")) {
            if (args.length > 0) {
                if (config.contains(playerBalance)) {
                    player.sendMessage(ChatColor.GREEN + "Balance: $" + config.getInt(args[0] + ".balance"));
                } else {
                    player.sendMessage(ChatColor.RED + "This player could not be found!");
                }
            } else {
                player.sendMessage(ChatColor.GREEN + "Balance: $" + config.getInt(playerBalance));
            }
        }
        return false;
    }
}
