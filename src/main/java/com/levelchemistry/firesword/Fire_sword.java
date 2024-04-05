package com.levelchemistry.firesword;

import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.attribute.Attribute;
import sun.font.EAttribute;

import java.util.Objects;

public final class Fire_sword extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.println("Sleep restore now enabled!");

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
        if (Objects.equals(playerName, "vx8")) event.setJoinMessage("Hahahaha its vx8");
    }
    //Mistake below was not calling event handler before attempting to use new event listeners
    //Method below restores health and hunger when a player leaves the bed, grabbing the max health value of the player first
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        Player player = event.getPlayer();
        double Health = player.getMaxHealth();
        player.setHealth(Health);
        player.setFoodLevel(20);
        player.sendRawMessage("Your health and hunger has been restored!");
    }
}
