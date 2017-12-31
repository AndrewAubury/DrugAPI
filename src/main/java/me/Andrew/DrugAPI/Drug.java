package me.Andrew.DrugAPI;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Drug {
	public String name;
	private double sellCost;
	private double buyCost;
	private String displayName;
	private int itemID;
	private boolean canCraft;

	public Drug(String name,int itemID,String displayName,double sellCost,double buyCost,boolean canCraft){
		setName(name);
		setItemID(itemID);
		setDisplayName(displayName);
		setSellCost(sellCost);
		setBuyCost(buyCost);
		setCanCraft(canCraft);

	}

	public void runAction(String name,Player p){
		DrugEvent event = new DrugEvent(p,this,name);
		DrugAPI.getInstance().MA.getServer().getPluginManager().callEvent(event);
	}
	public HashMap<String,Object> getInfo(){
		HashMap<String,Object> info = new HashMap<String,Object>();
		info.put("name", name);
		info.put("itemID", itemID);
		info.put("displayName", displayName);
		info.put("sellCost", sellCost);
		info.put("buyCost", buyCost);
		info.put("canCraft", canCraft);
		return info;
	}
    public double getSellCost() {
		return sellCost;
	}
    public ItemStack getDrugItem(){
		@SuppressWarnings("deprecation")
		ItemStack is = new ItemStack(getItemID());
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(getDisplayName());
		is.setItemMeta(im);
		return is;
    }
	private void setSellCost(double sellCost) {
		this.sellCost = sellCost;
	}
	public double getBuyCost() {
		return buyCost;
	}
	private void setBuyCost(double buyCost) {
		this.buyCost = buyCost;
	}
	public String getDisplayName() {
		return displayName;
	}
	private void setDisplayName(String displayName) {
		this.displayName = ChatColor.translateAlternateColorCodes('&',displayName);
	}
	public String getName() {
		return displayName;
	}
	private void setName(String Name) {
		this.name = Name;
	}
	public int getItemID() {
		return itemID;
	}
	private void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public boolean isCanCraft() {
		return canCraft;
	}
	private void setCanCraft(boolean canCraft) {
		this.canCraft = canCraft;
	}

    
}
