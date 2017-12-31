package me.Andrew.DrugAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * Created by Andrew on 31/12/2017.
 */
public class DrugEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private Player p;
    private Drug drug;
    private String event;
    private boolean cancelled;

    public DrugEvent(Player p, Drug drug, String event) {
        this.p = p;
        this.drug = drug;
        this.event = event;
    }

    public Player getP() {
        return p;
    }

    public Drug getDrug() {
        return drug;
    }

    public String getEvent() {
        return event;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}