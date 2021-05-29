package me.arr0w.events;

import me.arr0w.models.ParticleData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        ParticleData p = new ParticleData((e.getPlayer().getUniqueId()));
        if(p.hasID())
            p.endTask();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        ParticleData p = new ParticleData((e.getPlayer().getUniqueId()));
        if(p.hasID())
            p.endTask();
    }
}
