package core.core.handlers;

import core.core.Utility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatHandler implements Listener {
    public ChatHandler(Utility plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        e.setCancelled(true);

        if(player.isOp()) {
            Bukkit.broadcastMessage(ChatColor.RED + player.getName() + ": " + ChatColor.WHITE + message);
        }
        else {
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + ": " + ChatColor.WHITE + message);
        }
    }
}