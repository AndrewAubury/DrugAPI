package me.Andrew.DrugAPI;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main ma;

	public static Main getInstance() {
		return ma;
	}

	public void onEnable() {
		ma = this;
		saveDefaultConfig();
		new DrugAPI();
	}

}
