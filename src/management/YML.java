package management;

import java.util.List;

import org.bukkit.Location;

public class YML {
	private static Location lobby;
	
	//TODO locations am besten einen Block über den Goldblöcken spawnen
	private static List<Location> gold_locs;
	private static List<Location> iron_locs;
	private static List<Location> brick_locs;
	
	
	public static Location getLobby() {
		return lobby;
	}
	
	public static List<Location> getGold() {
		return gold_locs;
	}
	
	public static List<Location> getIron() {
		return iron_locs;
	}
	
	public static List<Location> getBrick() {
		return brick_locs;
	}
}
