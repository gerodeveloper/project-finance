package de.gero.finance;

import de.gero.finance.api.Company;
import de.gero.finance.api.Entrepeneur;
import de.gero.finance.commands.FinanceTestCommand;
import de.gero.finance.listener.JoinListener;
import de.gero.finance.listener.QuitListener;
import de.gero.finance.storage.StorageProvider;
import de.gero.finance.storage.provider.FileStorage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class FinancePlugin extends JavaPlugin {
    private static StorageProvider storageProvider;

    @Override
    public void onEnable() {
        storageProvider = new FileStorage();

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);

        this.getCommand("financetest").setExecutor(new FinanceTestCommand());

        // FIXME: Move to it's own class
        FinanceTestCommand.getSubcommandHashMap().put("createcompany", ((sender, command, label, args) -> {
            if (args.length != 2) {
                sender.sendMessage(ChatColor.RED + "Please specify one argument (company name)!");
                return true;
            }

            Player player = (Player) sender;
            ArrayList<UUID> companyOwners = new ArrayList();
            companyOwners.add(player.getUniqueId());
            Company company = new Company(args[1], companyOwners);
            Entrepeneur.getEntrepeneurMap().get(player.getUniqueId()).addCompany(company);

            player.sendMessage(ChatColor.GRAY + "You founded the company " + ChatColor.GREEN + args[1] + ChatColor.GRAY + "!");
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
            return true;
        }));

        // FIXME: Move to it's own class
        FinanceTestCommand.getSubcommandHashMap().put("listcompany", (sender, command, label, args) -> {
            Player player = (Player) sender;
            Entrepeneur entrepeneur = Entrepeneur.getEntrepeneurMap().get(player.getUniqueId());

            if (entrepeneur.getCompanyList().size() == 0) {
                player.sendMessage(ChatColor.GRAY + "You don't own any companies yet.");
                return true;
            }

            player.sendMessage(ChatColor.GRAY + "| " + ChatColor.GREEN + "Companies" + ChatColor.GRAY + " |");

            for (Company company : entrepeneur.getCompanyList()) {
                String suffix;
                if (company.getCompanyOwners().size() == 1) {
                    suffix = ChatColor.GRAY + "(Totally yours)";
                } else {
                    suffix = ChatColor.GRAY + "(Yours with " + ChatColor.GREEN + company.getCompanyOwners().size() + ChatColor.GRAY + " others)";
                }
                player.sendMessage(ChatColor.GRAY + "  - " + ChatColor.GREEN + company.getCompanyName() + " " + suffix);
            }

            return true;
        });

        for (Player player : Bukkit.getOnlinePlayers()) {
            Entrepeneur.getEntrepeneurMap().put(player.getUniqueId(), new Entrepeneur(player));
        }
    }

    @Override
    public void onDisable() {

    }

    public static StorageProvider getStorageProvider() {
        return storageProvider;
    }
}
