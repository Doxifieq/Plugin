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
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

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
                ArrayList<ItemStack> map = new ArrayList<>();

                map.add(new ItemStack(Material.DIRT));
                map.add(new ItemStack(Material.STONE));
                map.add(new ItemStack(Material.DIAMOND));
                map.add(new ItemStack(Material.DEAD_BUSH));
                map.add(new ItemStack(Material.GOLD_INGOT));
                map.add(new ItemStack(Material.IRON_INGOT));

                Random random = new Random();
                ItemStack item = map.get(random.nextInt(map.size()));

                player.getWorld().dropItemNaturally(block.getLocation(), item);
                block.setType(Material.AIR);
            }
        }
    }
}