package me.arr0w.events;

import me.arr0w.main.Main;
import me.arr0w.models.ParticleData;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Random;

public class Movement implements Listener {
    public static String getCardinalDirection(Player player) {
        double rotation = (player.getLocation().getYaw() - 180) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            return "N";
        } else if (22.5 <= rotation && rotation < 67.5) {
            return "NE";
        } else if (67.5 <= rotation && rotation < 112.5) {
            return "E";
        } else if (112.5 <= rotation && rotation < 157.5) {
            return "SE";
        } else if (157.5 <= rotation && rotation < 202.5) {
            return "S";
        } else if (202.5 <= rotation && rotation < 247.5) {
            return "SW";
        } else if (247.5 <= rotation && rotation < 292.5) {
            return "W";
        } else if (292.5 <= rotation && rotation < 337.5) {
            return "NW";
        } else if (337.5 <= rotation && rotation < 360.0) {
            return "N";
        } else {
            return null;
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Random r = new Random();
        //if(e.getTo().get)
        if(e.getPlayer().getVelocity().length()> 0)
        {
            for ( int i=0; i<2 ; i++)
                e.getPlayer().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,e.getPlayer().getLocation().add(r.nextDouble()*0.5,r.nextDouble()*0.5,r.nextDouble()*0.5),0);
        }

    }
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
        Location loc,first,second;

       // Location third,forth;
        //  e instanceof Player &&
        if (e instanceof Player && (event.getCause() == event.getCause().FALL || event.getCause() == event.getCause().ENTITY_ATTACK || event.getCause() == event.getCause().ENTITY_SWEEP_ATTACK || event.getCause() == event.getCause().SUFFOCATION || event.getCause() == event.getCause().DROWNING || event.getCause() == event.getCause().BLOCK_EXPLOSION || event.getCause() == event.getCause().ENTITY_EXPLOSION || event.getCause() == event.getCause().SUICIDE || event.getCause() == event.getCause().STARVATION || event.getCause() == event.getCause().THORNS || event.getCause() == event.getCause().ENTITY_ATTACK)){

            //((Player) e).getPlayer().sendMessage(" facing "+((Player) e).getPlayer().getFacing());
            loc = ((Player) e).getPlayer().getLocation();
            first = loc.clone();
            if(getCardinalDirection(((Player) e).getPlayer()) == "N")
                first = loc.clone().add(0.3,1,-1);
            else if(getCardinalDirection(((Player) e).getPlayer()) == "S")
                first = loc.clone().add(0.3,1,1);
            else if(getCardinalDirection(((Player) e).getPlayer()) == "W")
                first = loc.clone().add(-1,1,0.3);
            else if(getCardinalDirection(((Player) e).getPlayer()) == "E")
                first = loc.clone().add(1,1,0.3);
            else
                first = loc.clone().add(0,1,0);
//            first = loc.clone().add(((Player) e).getPlayer().getLocation().getDirection().getX()+0.5,1,((Player) e).getPlayer().getLocation().getDirection().getZ()+0.5);
//            second = loc.clone().add(((Player) e).getPlayer().getLocation().getDirection().getX()+0.5,1.5,((Player) e).getPlayer().getLocation().getDirection().getZ()+0.5);
//            third = loc.clone().add(-0.5,0,0.5);
//            forth = loc.clone().add(0.5,0,-0.5);

            //((Player) e).getPlayer().sendMessage("took damage from fall ");
            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,first,10);
            //((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,second,10);
//            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,third,0);
//            ((Player) e).getPlayer().getWorld().spawnParticle(Particle.HEART,forth,0);
        }
    }



    @EventHandler
    public void onArrowShot(ProjectileLaunchEvent e) {
        Player p = (Player)e.getEntity().getShooter();
        Projectile aw = e.getEntity();
        p.sendMessage("you shot arrow");

            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

                public void run() {
                    if(aw.isOnGround()){

                    }

                    else {
                        aw.getLocation().getWorld().spawnParticle(Particle.COMPOSTER,aw.getLocation(),20);
                    }
                }
            }, 0, 1);


    }
    @EventHandler
    public void playerBedEnter(PlayerBedEnterEvent e){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(Main.class), new Runnable(){

            double var = 0;
            Location loc, first,second,third,forth,fifth;
            @Override
            public void run() {
                for(int i =0; i<10;i++){
                    var +=Math.PI /16;
                    loc = e.getBed().getLocation();
                    first = loc.clone().add(3*Math.cos(var),3*(Math.sin(var)+1),3*Math.sin(var));
                    second = loc.clone().add(3*Math.cos(var+ Math.PI),3*Math.sin(var)+1,3*Math.sin(var+Math.PI));
                    third = loc.clone().add(3*Math.sin(var+ Math.PI),3*(Math.sin(var)+1),3*Math.cos(var+Math.PI));
                    forth = loc.clone().add(3*Math.cos(var),1,3*Math.sin(var));
                    fifth = loc.clone().add(3*Math.sin(var),3*(Math.sin(var)+1),3*Math.cos(var));

                    e.getBed().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,first,0);
                    e.getBed().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,second,0);
                    e.getBed().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,third,0);
                    e.getBed().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,forth,0);
                    e.getBed().getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR,fifth,0);
                    if(i==9)
                        return;
                }

            }
        }, 0, 1);



    }

}
