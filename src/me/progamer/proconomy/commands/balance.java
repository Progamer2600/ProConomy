package me.progamer.proconomy.commands;

import me.progamer.proconomy.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class balance implements CommandExecutor {
    Main main = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if (command.getName().equalsIgnoreCase("bal") || command.getName().equalsIgnoreCase("balance")) {
            if (args.length > 0) {
                if (main.getAccountData().contains(args[0])) {
                    player.sendMessage(ChatColor.GREEN + "Balance: " + main.getAccountData().getInt(args[0] + ".balance"));
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid Player!");
                }
            } else {
                player.sendMessage(ChatColor.GREEN + "Balance: " + main.getAccountData().getInt( player.getName() + ".balance"));

            }
        }
        return false;
    }
}