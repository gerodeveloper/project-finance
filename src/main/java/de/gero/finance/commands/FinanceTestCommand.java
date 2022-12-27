package de.gero.finance.commands;

import de.gero.finance.api.Subcommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Locale;

public class FinanceTestCommand implements CommandExecutor {
    private static HashMap<String, Subcommand> subcommandHashMap = new HashMap<>();

    public static HashMap<String, Subcommand> getSubcommandHashMap() {
        return subcommandHashMap;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Please use this command as a player.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission(command.getPermission())) {
            player.sendMessage(command.getPermissionMessage());
            return true;
        }
        if (args.length == 0) {
            player.sendMessage(command.getUsage());
            return true;
        }

        return subcommandHashMap.get(args[0].toLowerCase(Locale.ROOT)).handle(sender, command, label, args);
    }
}
