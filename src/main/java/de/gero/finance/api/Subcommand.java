package de.gero.finance.api;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface Subcommand {
    boolean handle(CommandSender sender, Command command, String label, String[] args);
}
