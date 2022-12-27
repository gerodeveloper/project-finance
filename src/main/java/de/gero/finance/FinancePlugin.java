package de.gero.finance;

import de.gero.finance.commands.FinanceTestCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FinancePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("financetest").setExecutor(new FinanceTestCommand());
    }

    @Override
    public void onDisable() {

    }
}
