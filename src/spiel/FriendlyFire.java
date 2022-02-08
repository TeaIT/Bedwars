package spiel;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class FriendlyFire implements Listener {
	@EventHandler
	public void onDamageTeammate(EntityDamageByEntityEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			if(e.getEntity() instanceof Player) {
				Player d = null;
				if(e.getDamager() instanceof Player) {
					d = (Player) e.getDamager();
				} else if(e.getDamager() instanceof Projectile) {
					Projectile proj = (Projectile) e.getDamager();
					if(proj.getShooter() instanceof Player) d = (Player) proj.getShooter();
				}
				Team friendly = Teams.getTeam(d);
				if(d!=null && friendly.members.contains(d.getUniqueId())) e.setCancelled(true); 
			}
		}
	}
}
