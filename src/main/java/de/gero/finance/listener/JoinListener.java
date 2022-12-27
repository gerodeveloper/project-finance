package de.gero.finance.listener;

import de.gero.finance.api.Entrepeneur;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent) {
        Entrepeneur.getEntrepeneurMap().put(joinEvent.getPlayer().getUniqueId(), new Entrepeneur(joinEvent.getPlayer()));
    }
}
