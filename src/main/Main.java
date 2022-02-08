package main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Plugin pl; 
	
	@Override
	public void onEnable() {
		pl = this;
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
	public static void shutdown() {
		for(Player p : Bukkit.getOnlinePlayers()) p.kickPlayer("§4Der Server restartet grade!");
		Bukkit.reload();
	}
}
