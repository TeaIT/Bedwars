package lobby;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;

import management.Phase;
import management.Verlauf;
import management.YML;

public class Join implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(Verlauf.phase == Phase.Lobby) {
			Player p = e.getPlayer();
			clear(p);
			p.setGameMode(GameMode.ADVENTURE);
	
			p.teleport(YML.getLobby());
			p.setLevel(Verlauf.lobby);
			
			e.setJoinMessage("§7"+ p.getName() + " ist dem Spiel beigetreten.");
		}
	}
	
	private void clear(Player p) {
		p.getInventory().clear();
		p.setHealth(20.0);
		p.setLevel(0);
		p.setExp(0);
		for(PotionEffect pe : p.getActivePotionEffects()) p.removePotionEffect(pe.getType());
		
	}
}
