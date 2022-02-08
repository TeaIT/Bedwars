package management;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import main.Main;

public class Verlauf {
	public static Phase phase = Phase.Lobby;
	
	public static final int lobbyD = 30;
	public static final int spielD = 60*30; //30 min
	public static final int endeD = 15;
	
	public static  int lobby = 30;
	public static  int spiel = 60*30; //30 min
	public static int ende = 15;
	
	private static Integer spielTaskID = null; //zum vorzeitigen Beenden des Spiels
	
	public static void start() {
		lobby();
	}
	
	private static void lobby() {
		lobby = lobbyD;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(lobby == 0) {
					spiel();
					cancel();
					return;
				}
				for(Player p : Bukkit.getOnlinePlayers()) p.setLevel(lobby);
				
				lobby--;
			}
		}.runTaskTimer(Main.pl, 0, 20);
	}
	
	private static void spiel() {
		spiel = spielD;
		
		initSpiel();
		
		spielTaskID = new BukkitRunnable() {
			
			@Override
			public void run() {
				if(spiel==0) {
					ende();
					cancel();
					return;
				}
				spiel--;
			}
		}.runTaskTimer(Main.pl, 0, 20).getTaskId();
	}
	
	private static void initSpiel() {
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.setGameMode(GameMode.SURVIVAL);
			//TODO teleportiere alle zu ihrem Team
		}
	}

	private static void ende() {
		ende = endeD;
		new BukkitRunnable() {
			
			@Override
			public void run() {
				if(ende == 0) {
					Main.shutdown();
					cancel();
					return;
				}
				
				ende--;
			}
		}.runTaskTimer(Main.pl, 0, 20);
	}
	
	public static void triggerWin(Team t) {
		if (spielTaskID != null) {
			Bukkit.getScheduler().cancelTask(spielTaskID);
			win(t);
			ende();
		}
	}
	
	private static void win(Team t) {
		
	}
}
