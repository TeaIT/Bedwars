package lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import management.Phase;
import management.Verlauf;

public class NoDamage implements Listener {
	@EventHandler
	public void onLobbyDamage(EntityDamageEvent e) {
		if(Verlauf.phase == Phase.Lobby) e.setCancelled(true);
	}
}
