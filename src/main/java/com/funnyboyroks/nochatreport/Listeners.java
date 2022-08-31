package com.funnyboyroks.nochatreport;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class Listeners implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncChatEvent event) {
        event.setCancelled(true);
        Player player = event.getPlayer();
        Component msg = event.message();
        Component name = event.getPlayer().displayName();

        Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(
            event.renderer().render(player, name, msg, p)
        ));

        Bukkit.getConsoleSender().sendMessage(
            Component.text("[CHAT] ")
                .append(
                    event.renderer().render(player, name, msg, Bukkit.getConsoleSender())
                )
        );
    }

}
