package me.arr0w.events;

import me.arr0w.models.Effects;
import me.arr0w.models.GUI;
import me.arr0w.models.ParticleData;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ClickEvent implements Listener {
    private GUI menu;
    public ClickEvent(){
        menu = new GUI();
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(!e.getInventory().equals(menu.getInventory()))
            return;
        Player player = (Player) e.getWhoClicked();
        e.setCancelled(true);

        if(e.getView().getType() == InventoryType.PLAYER)
            return;

        ParticleData particle = new ParticleData(player.getUniqueId());

        if(particle.hasID()){
            particle.endTASk();
            particle.removeID();
        }

        Effects trails = new Effects(player);

        switch(e.getSlot()) {
            case 3:
                trails.startjump();
                player.closeInventory();
                player.updateInventory();
                break;
            case 5:
                trails.startwalk();
                player.closeInventory();
                player.updateInventory();
                break;
            default:
                break;
        }
    }

}

