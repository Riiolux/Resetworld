package de.riolux.resetworl;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("Der Server wird resetet"));
        Main.getInstance().getConfig().set("isReset", true);
        Main.getInstance().saveConfig();
        Bukkit.spigot().restart();


        return false;
    }
}
