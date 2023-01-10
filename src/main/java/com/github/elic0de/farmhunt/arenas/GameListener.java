package com.github.elic0de.farmhunt.arenas;

import com.github.elic0de.farmhunt.Farmhunt;
import com.github.elic0de.farmhunt.Game;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class GameListener implements Listener {

    private final Game game = Farmhunt.getInstance().getGame();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        game.getGameFrameWork().join(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        game.getGameFrameWork().leave(event.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        game.death(event.getEntity());
    }
}
