package lobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import function.Teleport;
import management.Phase;
import management.Verlauf;
import management.YML;

public class Void implements Listener {
	@EventHandler
	public void onVoidDamage(EntityDamageEvent e) {
		if(Verlauf.phase == Phase.Lobby) {
			if(e.getEntity() instanceof Player && e.getCause() == DamageCause.VOID) {
				e.setCancelled(true);
				Player p = (Player ) e.getEntity();
				Teleport.fromVoid(p, YML.getLobby());
			}
		}
	}
}
