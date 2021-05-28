package me.arr0w.models;

import me.arr0w.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Effects {
    private int taskID;
    private final Player player;
    public Effects(Player player){
        this.player = player;
    }

    public void startjump(){
        taskID  = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first,second,third,forth,fifth;
            ParticleData particles = new ParticleData(player.getUniqueId());
            @Override
            public void run() {
                if(!particles.hasID()){
                    particles.setID(taskID);
                }
                var +=Math.PI /16;
                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var),Math.sin(var)+1,Math.sin(var));
                second = loc.clone().add(Math.cos(var+ Math.PI),Math.sin(var)+1,Math.sin(var+Math.PI));
                third = loc.clone().add(Math.sin(var+ Math.PI),Math.sin(var)+1,Math.cos(var+Math.PI));
                forth = loc.clone().add(Math.cos(var),1,Math.sin(var));
                fifth = loc.clone().add(Math.sin(var),Math.sin(var)+1,Math.cos(var));

                player.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,first,0);
                player.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,second,0);
                player.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,third,0);
                player.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,forth,0);
                player.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,fifth,0);
            }
        },0,1);
    }

    public void startwalk(){
        taskID  = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable() {

            double var = 0;
            Location loc, first,second,third,forth;
            ParticleData particles = new ParticleData(player.getUniqueId());
            @Override
            public void run() {
                if(!particles.hasID()){
                    particles.setID(taskID);
                }
                var +=Math.PI /16;
                loc = player.getLocation();
                first = loc.clone().add(0.5,0,0.5);
                second = loc.clone().add(-0.5,0,-0.5);
                third = loc.clone().add(-0.5,0,0.5);
                forth = loc.clone().add(0.5,0,-0.5);

                //player.getWorld().spawnParticle(Particle.HEART,loc,0);
                player.getWorld().spawnParticle(Particle.SLIME,first,0);
                player.getWorld().spawnParticle(Particle.SLIME,second,0);
                player.getWorld().spawnParticle(Particle.SLIME,third,0);
                player.getWorld().spawnParticle(Particle.SLIME,forth,0);

            }
        },0,1);
    }
}
