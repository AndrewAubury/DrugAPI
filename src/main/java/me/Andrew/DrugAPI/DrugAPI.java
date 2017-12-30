package me.Andrew.DrugAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.configuration.ConfigurationSection;

public class DrugAPI {
	Main MA;
	private static DrugAPI instance = null;
	private HashMap<String, Drug> drugStore = new HashMap<String, Drug>();
	
	protected DrugAPI() {
		MA = Main.getInstance();
		setupDrugs();
	}

	public static DrugAPI getInstance() {
		if (instance == null) {
			instance = new DrugAPI();
		}
		return instance;
	}
	public void setupDrugs(){
		for(String drug : getDrugList()){
			if(!drugStore.containsKey(drug)){
				 ConfigurationSection drugConfig = MA.getConfig().getConfigurationSection("Drugs."+drug);
				 String name = drug;
				 double sellCost = drugConfig.getDouble("sell-cost");
				 double buyCost = drugConfig.getDouble("buy-cost");
				 String displayName = drugConfig.getString("displayname");
				 int itemID = drugConfig.getInt("itemID");
				 boolean canCraft = drugConfig.getBoolean("can-craft");
				 drugStore.put(drug, new Drug(name,itemID,displayName,sellCost,buyCost,canCraft));
			}
		}
	}
	public ArrayList<String> getDrugList(){
		Set<String> values = MA.getConfig().getConfigurationSection("Drugs").getKeys(false);
		ArrayList<String> drugs = new ArrayList<String>();
		for(String key : values){
			drugs.add(key);
		}
		
		return drugs;
	}
	public Drug getDrug(String name){
		return drugStore.get(name);
	}
	public Drug getDrugFromID(int id){
		for(String drug : getDrugList()){
			Drug d = drugStore.get(drug);
			if(id == d.getItemID()){
				return d;
			}
		}
		return null;
	}
	
}
