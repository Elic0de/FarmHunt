package com.github.elic0de.farmhunt;

import org.bukkit.plugin.java.JavaPlugin;

public final class Farmhunt extends JavaPlugin {

    private static Farmhunt instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Farmhunt getInstance() {
        return instance;
    }
}
