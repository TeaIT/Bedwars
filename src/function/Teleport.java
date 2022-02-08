package function;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import main.Main;

public class Teleport {
	public static void fromVoid(Player p, Location loc) {
		new BukkitRunnable() {
			@Override
			public void run() {
				p.teleport(loc);
			}
		}.runTaskLater(Main.pl, 1); //es gibt einen Bugg, beim Teleportieren nach VoidDamage, diesen umgeht man so
	}
}
