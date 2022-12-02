package core.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class clearinventory implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null) {
                    target.getInventory().clear();
                    target.sendMessage(ChatColor.YELLOW + "Your inventory has been cleared.");

                    player.sendMessage(ChatColor.YELLOW + "Cleared inventory of " + ChatColor.WHITE + target.getName() + ".");

                    return true;
                }
            }

            player.getInventory().clear();
            player.sendMessage(ChatColor.YELLOW + "Your inventory has been cleared.");

            return true;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}