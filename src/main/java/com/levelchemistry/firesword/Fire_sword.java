package com.levelchemistry.firesword;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
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
        if (Objects.equals(playerName, "vx8")) event.setJoinMessage("Hahahaha its vx8");
    }
    //Mistake below was not calling event handler before attempting to use new event listeners
    //Method below restores health and hunger when a player leaves the bed
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendRawMessage("Your health and hunger has been restored!");
    }
}
