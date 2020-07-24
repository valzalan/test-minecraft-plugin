package com.valzalan.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class TestPlugin extends JavaPlugin {
    @SuppressWarnings("FieldCanBeLocal")
    private final String JUMP_COMMAND = "myjump";

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase(JUMP_COMMAND)) {
            if(!stringArgumentIsValid(args[0])) {
                getLogger().info("You should invoke this command with at least one argument!");
                return false;
            }
            Bukkit.dispatchCommand(sender, "mv tp " + args[0]);
            return true;
        }
        return false;
    }

    private boolean stringArgumentIsValid(String arg){
        return arg != null && !arg.isEmpty();
    }
}
