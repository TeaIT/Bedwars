package spiel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import function.Teleport;
import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class Void implements Listener {
	@EventHandler
	public void onVoidDamage(EntityDamageEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			if(e.getEntity() instanceof Player && e.getCause() == DamageCause.VOID) {
				e.setCancelled(true);
				Player p = (Player ) e.getEntity();
				Team t = Teams.getTeam(p);
				if(t!=null) Teleport.fromVoid(p,t.getSpawn());
			}
		}
	}
}
