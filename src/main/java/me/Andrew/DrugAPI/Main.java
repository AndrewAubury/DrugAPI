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
		ma.getServer().getLogger().info("This is just the API. Drugs have no function with out addons.");
		getServer().getPluginManager().registerEvents(new EventCatcher(),this);
		DrugAPI.getInstance();
	}

}
