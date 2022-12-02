package core.core.handlers;

import core.core.Utility;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockHandler implements Listener {
    public BlockHandler(Utility plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if(e.getClickedBlock() != null && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();

            if(block.getType() == Material.GOLD_BLOCK) {
                block.setType(Material.AIR);
            }
        }
    }
}