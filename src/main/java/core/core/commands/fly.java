package core.core.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            boolean currentMode = player.getAllowFlight();

            player.setAllowFlight(!currentMode);
            player.sendMessage(ChatColor.YELLOW + "Set flight mode to " + ChatColor.WHITE + Boolean.toString(!currentMode).toUpperCase());

            return true;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}