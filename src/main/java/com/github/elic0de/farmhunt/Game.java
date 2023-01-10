package com.github.elic0de.farmhunt;

import com.github.elic0de.framework.GameFrameWork;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Game {

    private final GameFrameWork gameFrameWork;
    private Player ao;
    private Player aka;

    public Game() {
        gameFrameWork = new GameFrameWork(Farmhunt.getInstance()).build();

        gameFrameWork.setGameStartAction(player -> {
            sendTitle("節分イベント！鬼を討伐せよ！","");
            playSound(Sound.ITEM_GOAT_HORN_SOUND_0);
            if (player == aka || player == ao) {
                player.getInventory().clear();
                player.updateInventory();
                player.setGameMode(GameMode.SURVIVAL);
                return;
            }

            player.getInventory().clear();
            player.getInventory().addItem(new ItemStack(Material.SNOWBALL));
            player.updateInventory();
            player.setGameMode(GameMode.SURVIVAL);
        });
    }

    public void start() {
        gameFrameWork.start();
    }

    public void end() {
        gameFrameWork.end();
    }

    public void death(Player player) {
        if(isDemon(player)) {
            player.setGameMode(GameMode.SPECTATOR);
            player.playSound(player, Sound.ENTITY_WITHER_SPAWN,1,1);
            player.playEffect(EntityEffect.FIREWORK_EXPLODE);
            sendTitle("鬼を討伐しました","");
            return;
        }
        player.setGameMode(GameMode.SPECTATOR);
        player.getWorld().strikeLightningEffect(player.getLocation());
    }


    private void sendTitle(String title, String subTitle) {
        for (Player player : getPlayers()) {
            player.sendTitle(title, subTitle, 20,60,20);
        }
    }

    private void playSound(Sound sound) {
        for (Player player : getPlayers()) {
            player.playSound(player, sound,1,1);
        }
    }

    private boolean isDemon(Player player) {
        return ao == player || aka == player;
    }

    private List<Player> getPlayers() {
        return gameFrameWork.getPlayers();
    }

    public GameFrameWork getGameFrameWork() {
        return gameFrameWork;
    }
}
