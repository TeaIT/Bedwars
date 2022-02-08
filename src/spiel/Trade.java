package spiel;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class Trade implements Listener {
	public static Inventory trade_inventory = initInventory();
	
	@EventHandler
	public void onTrade(PlayerInteractEntityEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			if(e.getRightClicked() instanceof Villager) {
				Villager v = (Villager) e.getRightClicked();
				if(v.getCustomName().equals(Team.villager_name)) {
					e.setCancelled(true);
					Player p = e.getPlayer();
					
					Team t = Teams.getTeam(p);
					
					if(t != null) {
						openInventory();
					}
				}
			}
		}
	}

	private static Inventory initInventory() {
		return null;
	}

	private void openInventory() {
		// TODO Auto-generated method stub
		
	}
}
