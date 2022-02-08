package spiel;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import management.Phase;
import management.Teams;
import management.Verlauf;
import management.YML;

public class Join implements Listener {
	
	//Spectator
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			e.setJoinMessage(null);
			Player p = e.getPlayer();
			p.setGameMode(GameMode.SPECTATOR);
			
			Player random_player = Teams.getRandomPlayer();
			if(random_player!=null) p.teleport(random_player);
			else p.teleport(YML.getLobby());
		}
	}
}
