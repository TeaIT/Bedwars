package management;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import main.Main;

public class Teams {
	public static Set<Team> teams = new HashSet<>();
	
	public static Team getTeam(Player p) {
		for(Team t : teams) {
			if(t.members.contains(p.getUniqueId())) return t;
		}
		return null;
	}
	
	public static Team getTeam(Location bed_loc) {
		World w = bed_loc.getWorld();
		int x = bed_loc.getBlockX();
		int y = bed_loc.getBlockY();
		int z = bed_loc.getBlockZ();
		
		for(Team t : teams) {
			int x2 = t.getBedLoc().getBlockX();
			int y2 = t.getBedLoc().getBlockY();
			int z2 = t.getBedLoc().getBlockZ();
			
			if(t.getBedLoc().getWorld().equals(w) && x == x2 && y == y2 && z == z2) return t;
		}
		return null;
	}

	public static void checkWipedOut(Team t) {
		if(t.members.size() == 0) {
			teams.remove(t);
			
			for(Player all : Bukkit.getOnlinePlayers()) all.sendMessage("§7Das Team "+t.getName() + " wurde vernichtet!");
			
			if(teams.size() == 1) {
				Team winner = (Team) teams.toArray()[0];
				Verlauf.triggerWin(winner);
			} else if(teams.size() == 0) Main.shutdown();
		}
	}
	
	public static Player getRandomPlayer() {
		if(teams.size() == 0) return null;
		int i = (int) (Math.random()*teams.size());
		Team t = (Team) teams.toArray()[i];
		int j = (int) (Math.random()*t.members.size());
		UUID uuid = (UUID) t.members.toArray()[j];
		return Bukkit.getPlayer(uuid);
	}
}
