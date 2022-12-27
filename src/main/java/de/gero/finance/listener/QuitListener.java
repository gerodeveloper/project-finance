package de.gero.finance.listener;

import de.gero.finance.api.Entrepeneur;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent quitEvent) {
        Entrepeneur.getEntrepeneurMap().remove(quitEvent.getPlayer().getUniqueId());
    }
}
