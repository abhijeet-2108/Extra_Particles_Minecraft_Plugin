package me.arr0w.commands;

import me.arr0w.models.GUI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Trail implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args){
        if (lable.equalsIgnoreCase("particles")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED +"You don't have permission.");
                return true;
            }
            Player player = (Player) sender;
            GUI menu = new GUI();
            menu.openInventory(player);
            return true;
        }
        return false;
    }

}
