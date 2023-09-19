package com.levelchemistry.firesword;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Fire_sword extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Fire sword now enabled!");

        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        System.out.println("Fire sword now disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        event.setJoinMessage("Welcome!");
        // Code below sets a join message to Welcome Level Chemistry if my username is found on the player join event
        String playerName;
        playerName = String.valueOf(event.getPlayer().getName());
        if (Objects.equals(playerName, "LevelChemistry")) event.setJoinMessage("Welcome Level Chemistry!");
    }
}
