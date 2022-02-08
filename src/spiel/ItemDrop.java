package spiel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import management.YML;

public class ItemDrop {
	private final int goldD=30;
	private final int ironD=15;
	private final int brickD=3;
	
	private int gold=goldD;
	private int iron=ironD;
	private int brick=brickD;

	ItemStack gold_istack = new ItemStack(Material.GOLD_INGOT);
	ItemStack iron_istack = new ItemStack(Material.GOLD_INGOT);
	ItemStack brick_istack = new ItemStack(Material.GOLD_INGOT);
	
	public void trigger() {
		if(gold==0) {
			gold=goldD;
			dropGold();
		}
		if(iron==0) {
			iron=ironD;
			dropIron();
		}
		if(brick==0) {
			brick=brickD;
			dropBrick();
		}
		gold--;
		iron--;
		brick--;
	}
	
	private void dropGold() {
		for(Location loc : YML.getGold()) {
			Item i = loc.getWorld().dropItem(loc, gold_istack);
			i.setVelocity(new Vector(0,0.75, 0));
		}
	}
	
	private void dropIron() {
		for(Location loc : YML.getIron()) {
			Item i = loc.getWorld().dropItem(loc, iron_istack);
			i.setVelocity(new Vector(0,0.5, 0));
		}
	}
	
	private void dropBrick() {
		for(Location loc : YML.getBrick()) {
			Item i = loc.getWorld().dropItem(loc, brick_istack);
			i.setVelocity(new Vector(0,0.25, 0));
		}
	}
}
