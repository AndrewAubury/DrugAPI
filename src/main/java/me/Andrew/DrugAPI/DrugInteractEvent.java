package me.Andrew.DrugAPI;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Andrew on 31/12/2017.
 */
public class DrugInteractEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private Player p;
    private Drug drug;
    private Action action;
    private boolean cancelled;
    private boolean sneaking;
    private PlayerInteractEvent interact;

    public DrugInteractEvent(Player p, Drug drug, Action action, PlayerInteractEvent e) {
        this.p = p;
        this.drug = drug;
        this.action = action;
        this.sneaking = p.isSneaking();
        this.interact = e;
    }

    public Player getPlayer() {
        return p;
    }

    public PlayerInteractEvent getInteractEvent(){return interact;}
    public Drug getDrug() {
        return drug;
    }

    public Boolean isSneaking() {
        return sneaking;
    }

    public Action getAction() {
        return action;
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