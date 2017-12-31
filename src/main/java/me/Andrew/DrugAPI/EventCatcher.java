package me.Andrew.DrugAPI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Andrew on 31/12/2017.
 */
public class EventCatcher implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Drug d = DrugAPI.getInstance().isDrug(e.getItem());
        if(d != null){
            DrugInteractEvent event = new DrugInteractEvent(e.getPlayer(),d,e.getAction(),e);
            Main.getInstance().getServer().getPluginManager().callEvent(event);
        }
    }
}
