package general;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import spiel.BedDestroy;

public class BlockBreak implements Listener {
	private static Set<Material> allowed = init();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		if(e.getPlayer() != null) {
			Player p = e.getPlayer();
			if(p.getGameMode() == GameMode.SURVIVAL && !allowed.contains(e.getBlock().getType())) e.setCancelled(true);
		}
	}

	private static Set<Material> init() {
		Set<Material> set = new HashSet<>();
		set.add(Material.SANDSTONE);
		set.add(BedDestroy.BED_MATERIAL);
		
		return set;
	}
}
