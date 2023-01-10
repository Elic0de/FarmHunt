package com.github.elic0de.farmhunt;

import com.github.elic0de.framework.GameFrameWork;
import org.bukkit.plugin.java.JavaPlugin;

public final class Farmhunt extends JavaPlugin {

    private static Farmhunt instance;

    private Game game;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        game = new Game();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Farmhunt getInstance() {
        return instance;
    }

    public Game getGame() {
        return game;
    }
}
