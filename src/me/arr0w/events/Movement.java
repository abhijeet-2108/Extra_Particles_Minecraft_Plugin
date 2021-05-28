package me.arr0w.events;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Movement implements Listener {
//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event) {
//        Block up, down;
//        if (event.getTo().getY() > event.getFrom().getY()) {
//            //up = event.getPlayer().getWorld().getBlockAt(new Location(event.getPlayer().getWorld(), event.getTo().getX(), event.getTo().getY() + 4, event.getTo().getZ()));
//            down = event.getPlayer().getWorld().getBlockAt(new Location(event.getPlayer().getWorld(), event.getTo().getX(), event.getTo().getY() - 3, event.getTo().getZ()));
//            if ((down.getType() == Material.AIR)) {
//                event.getPlayer().sendMessage(ChatColor.GRAY + "Woosh!");
//                event.getPlayer().getWorld().spawnParticle(Particle.HEART,event.getPlayer().getLocation(),0);
//            }
//        }
//    }
    @EventHandler
    public void myListener(EntityDamageEvent event){
        Entity e = event.getEntity();
        Location loc,first,second,third,forth;
        if (e instanceof Player && event.getCause() == event.getCause().FALL){
            loc = ((Player) e).getPlayer().getLocation();
            first = loc.clone().add(0.5,0,0.5);
            second = loc.clone().add(-0.5,0,-0.5);
            third = loc.clone().add(-0.5,0,0.5);
            forth = loc.clone().add(0.5,0,-0.5);

            ((Player) e).getPlayer().sendMessage("took damage from fall");
            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,first,0);
            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,second,0);
            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,third,0);
            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,forth,0);
        }
    }
}
