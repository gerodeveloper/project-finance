package de.gero.finance.storage;

import de.gero.finance.api.Company;
import de.gero.finance.api.Entrepeneur;

import java.util.UUID;

public interface StorageProvider {
    boolean saveCompany(Company company);
    Company loadCompany(String name);
    Entrepeneur loadEntrepeneur(UUID uuid);
}
