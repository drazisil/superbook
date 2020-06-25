package com.drazisil.superbook;

import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Arrays;
import java.util.Set;

import static com.drazisil.superbook.SuperBook.*;

public class EventListener implements Listener {

    @EventHandler
    public void OnPlayerLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Score playerScore = getRulesObjective().getScore(player.getName());

        if (!(playerScore.isScoreSet())) {
            ConsoleCommandSender console = plugin.getServer().getConsoleSender();

            // TODO: Set books to give on join in the config

            plugin.getServer().dispatchCommand(console, "superbook give " + player.getName() + " rules");
            plugin.getServer().dispatchCommand(console, "superbook give " + player.getName() + " info");
        }



    }
}
