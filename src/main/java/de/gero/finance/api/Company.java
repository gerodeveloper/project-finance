package de.gero.finance.api;

import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Entrepeneur> companyOwners;

    public Company(String companyName, ArrayList<Entrepeneur> companyOwners) {
        this.companyName = companyName;
        this.companyOwners = companyOwners;
    }

    public void addOwner(Entrepeneur entrepeneur) {
        this.companyOwners.add(entrepeneur);
    }

    public void removeOwner(Entrepeneur entrepeneur) {
        this.companyOwners.remove(entrepeneur);
    }

    public void save() {
        // TODO: Save Company information to storage provider.
    }
}
