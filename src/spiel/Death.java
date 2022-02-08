package spiel;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class Death implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			Player p = e.getEntity();
			Team t = Teams.getTeam(p); 
			
			if(t!=null) {
				if(t.isBedDestroyed()) {
					t.members.remove(p.getUniqueId());
					p.setGameMode(GameMode.SPECTATOR);
					
					Teams.checkWipedOut(t);
				} else {
					p.teleport(t.getSpawn());
				}
			}
			e.setDeathMessage(null);
		}
	}
}
