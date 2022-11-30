package core.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class smite implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if(sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;

            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if(target != null) {
                    target.setHealth(0);
                    target.getWorld().strikeLightningEffect(target.getLocation());

                    player.sendMessage(target.getName() + ChatColor.YELLOW + " has been smitten");

                    return true;
                }

                player.sendMessage(ChatColor.DARK_RED + args[0] + ChatColor.RED + " is either offline or an invalid player name");

                return true;
            }
            return false;
        }
        sender.sendMessage(ChatColor.RED + "Insufficient permissions.");

        return true;
    }
}