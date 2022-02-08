package spiel;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import management.Phase;
import management.Team;
import management.Teams;
import management.Verlauf;

public class BedDestroy implements Listener {
	public static final Material BED_MATERIAL = Material.DIAMOND_BLOCK;
	
	@EventHandler
	public void onDestroy(BlockBreakEvent e) {
		if(Verlauf.phase == Phase.Spiel) {
			if(e.getPlayer() != null) {
				Player p = e.getPlayer();
				if(e.getBlock().getType() == BED_MATERIAL) {
					Team t = Teams.getTeam(p);
					if(t!=null) {
						Team bed_team = Teams.getTeam(e.getBlock().getLocation());
						if(bed_team!=null && t!=bed_team) {
							bed_team.destroyBed();
						}
					}
				}
			}
		}
	}
}
