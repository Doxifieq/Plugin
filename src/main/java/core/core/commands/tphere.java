package core.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class tphere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null) {
                    player.sendMessage(ChatColor.YELLOW + "Teleporting " + ChatColor.WHITE + target.getName() + ChatColor.YELLOW + " to " + ChatColor.WHITE + player.getName());

                    target.teleport(player.getLocation());

                    return true;
                }
                player.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.RED + " is either offline or an invalid player name.");

                return true;
            }
            return false;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}