package com.drazisil.superbook;

import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Arrays;
import java.util.Set;

import static com.drazisil.superbook.SuperBook.*;

public class EventListener implements Listener {

    @EventHandler
    public void OnPlayerLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!(getRulesObjective().getScore(player.getName()).isScoreSet())) {
            ConsoleCommandSender console = plugin.getServer().getConsoleSender();

            plugin.getServer().dispatchCommand(console, "superbook give " + player.getName() + " rules");
        }



    }
}
