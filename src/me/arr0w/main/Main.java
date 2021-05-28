package me.arr0w.main;

import me.arr0w.commands.Trail;
import me.arr0w.events.ClickEvent;
import me.arr0w.events.Movement;
import me.arr0w.models.GUI;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        GUI menu = new GUI();
        menu.register();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ClickEvent(),this);
        pm.registerEvents(new Movement(), this);

        this.getCommand("particles").setExecutor(new Trail());
    }

    @Override
    public void onDisable() {

    }
}
