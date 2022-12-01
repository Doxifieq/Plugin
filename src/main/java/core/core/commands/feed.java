package core.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class feed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            player.setFoodLevel(20);
            player.sendMessage(ChatColor.YELLOW + "Your hunger bar has been replenished.");

            return true;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}