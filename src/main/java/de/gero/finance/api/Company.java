package de.gero.finance.api;

import de.gero.finance.FinancePlugin;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.UUID;

public class Company {
    private String companyName;

    // TODO: Owners can own shares of different sizes
    private ArrayList<UUID> companyOwners;

    public Company(String companyName, ArrayList<UUID> companyOwners) {
        this.companyName = companyName;
        this.companyOwners = companyOwners;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ArrayList<UUID> getCompanyOwners() {
        return companyOwners;
    }

    public void addOwner(UUID offlinePlayer) {
        this.companyOwners.add(offlinePlayer);
    }

    public void removeOwner(UUID offlinePlayer) {
        this.companyOwners.remove(offlinePlayer);
    }

    public void save() {
        FinancePlugin.getStorageProvider().saveCompany(this);
    }
}
