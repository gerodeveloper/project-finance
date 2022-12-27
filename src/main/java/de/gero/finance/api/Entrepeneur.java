package de.gero.finance.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Entrepeneur {
    // Object holding data for each player.
    private static HashMap<UUID, Entrepeneur> entrepeneurMap = new HashMap<>();

    private Player player;
    private ArrayList<Company> companyList;

    public Entrepeneur(Player player) {
        this.player = player;
        this.companyList = new ArrayList<>();
    }

    public void setCompanyList(ArrayList<Company> companyList) {
        this.companyList = companyList;
    }

    public void addCompany(Company company) {
        this.companyList.add(company);
    }

    public void removeCompany(Company company) {
        this.companyList.remove(company);
    }

    public ArrayList<Company> getCompanyList() {
        return companyList;
    }

    public static HashMap<UUID, Entrepeneur> getEntrepeneurMap() {
        return entrepeneurMap;
    }
}
