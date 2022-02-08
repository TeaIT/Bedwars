package management;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

import spiel.BedDestroy;

public class Team {
	public static final String villager_name = "§9Bobby";
	
	private String name;
	
	private Location spawn;
	private Location villager_loc;
	private Location bed_loc;
	
	public Set<UUID> members;
	private boolean bed_destroyed;
	
	public Team(String name, Location spawn, Location villager_loc, Location bed_loc) {
		this.name=name;
		this.spawn = spawn;
		this.villager_loc = villager_loc;
		this.bed_loc = bed_loc;
		members = new HashSet<UUID>();
		bed_destroyed=false;
		
		spawnVillager();
		setBed();
	}
	
	public void destroyBed() {
		bed_destroyed=true;
	}
	
	public boolean isBedDestroyed() {
		return bed_destroyed;
	}
	
	public String getName() {
		return name;
	}
	
	public Location getBedLoc() {
		return bed_loc;
	}
	
	public Location getSpawn() {
		return spawn;
	}
	
	private void spawnVillager() {
		Entity ent = villager_loc.getWorld().spawnEntity(villager_loc, EntityType.VILLAGER);
		Villager v = (Villager) ent;
		v.setAdult();
		v.setCanPickupItems(false);
		v.setInvulnerable(true);
		v.setCustomName(villager_name);
	}
	
	private void setBed() {
		bed_loc.getBlock().setType(BedDestroy.BED_MATERIAL);
	}
}
