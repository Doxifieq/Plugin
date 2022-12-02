package core.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            player.setHealth(Objects.requireNonNull(player.getAttribute(Attribute.GENERIC_MAX_HEALTH)).getValue());
            player.setFoodLevel(20);
            player.sendMessage(ChatColor.YELLOW + "You have been healed.");

            return true;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}