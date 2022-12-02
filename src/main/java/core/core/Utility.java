package core.core;

import core.core.commands.*;
import core.core.handlers.BlockHandler;
import core.core.handlers.ChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Utility extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("[Utility] Enabled Utility V1.0-SNAPSHOT");

        new BlockHandler(this);
        new ChatHandler(this);

        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new gamemode());
        Objects.requireNonNull(getCommand("smite")).setExecutor(new smite());
        Objects.requireNonNull(getCommand("night")).setExecutor(new night());
        Objects.requireNonNull(getCommand("time")).setExecutor(new time());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new heal());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feed());
        Objects.requireNonNull(getCommand("day")).setExecutor(new day());
        Objects.requireNonNull(getCommand("fly")).setExecutor(new fly());
    }
}