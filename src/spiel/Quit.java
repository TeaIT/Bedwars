package spiel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class Quit implements Listener{
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			e.setQuitMessage(null);
			Player p = e.getPlayer();
			Team t = Teams.getTeam(p);
			if(t!=null) {
				t.members.remove(p.getUniqueId());
				Teams.checkWipedOut(t);
			}
		}
	}
}
