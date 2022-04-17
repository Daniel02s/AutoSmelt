package me.fanta.autosmelt;

import me.fanta.autosmelt.commands.ReloadCommandAutoSmelt;
import me.fanta.autosmelt.events.AutoPickUp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoSmelt extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("");
        Bukkit.getServer().getPluginManager().registerEvents(new AutoPickUp(this), this);
        getCommand("autosmelt").setExecutor(new ReloadCommandAutoSmelt(this));
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        
        
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
