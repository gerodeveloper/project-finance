package de.gero.finance.storage.provider;

import de.gero.finance.api.Company;
import de.gero.finance.api.Entrepeneur;
import de.gero.finance.storage.StorageProvider;

import java.util.UUID;

public class FileStorage implements StorageProvider {
    @Override
    public boolean saveCompany(Company company) {
        return false;
    }

    @Override
    public Company loadCompany(String name) {
        return null;
    }

    @Override
    public Entrepeneur loadEntrepeneur(UUID uuid) {
        return null;
    }
}
