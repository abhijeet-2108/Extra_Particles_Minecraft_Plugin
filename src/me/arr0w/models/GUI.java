package me.arr0w.models;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI {

    private static Inventory INV;

    public void register(){
        Inventory inv = Bukkit.createInventory(null,9, ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Particles GUI");

        ItemStack item= new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta= item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN+"Jump particles");
        item.setItemMeta(meta);
        inv.setItem(3,item);

        item= new ItemStack(Material.COMPASS);
        meta= item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN+"walk particles");
        item.setItemMeta(meta);
        inv.setItem(5,item);

        setInvetory(inv);
    }
    public Inventory getInventory(){
        return INV;
    }

    private void setInvetory (Inventory inv){
        INV=inv;
    }

    public void openInventory(Player player) {
        player.openInventory(INV);

    }
}
