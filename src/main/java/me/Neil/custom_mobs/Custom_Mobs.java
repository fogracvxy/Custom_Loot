package me.Neil.custom_mobs;

import me.Neil.custom_mobs.commands.CustomItems;
import me.Neil.custom_mobs.events.CustomItemEvents;
import me.Neil.custom_mobs.events.UpdateBossHealthTag;
import me.Neil.custom_mobs.events.ZombieBossEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Custom_Mobs extends JavaPlugin {

    public static Custom_Mobs plugin;

    @Override
    public void onEnable() {
        getCommand("customitems").setExecutor(new CustomItems());
        getServer().getPluginManager().registerEvents(new ZombieBossEvents(), this);
        getServer().getPluginManager().registerEvents(new UpdateBossHealthTag(), this);
        getServer().getPluginManager().registerEvents(new CustomItemEvents(), this);
        plugin = this;
        System.out.println("Custom mobs plugin enabled");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
