package me.akitsuki.makoto.events;

import me.akitsuki.makoto.Makoto;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTransportEventListener implements Listener {
    final private Makoto plugin;

    public PlayerTransportEventListener(Makoto plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        var player = event.getPlayer();

        // log player's target location
        plugin.getLocHistory().put(player.getUniqueId(), player.getLocation());
    }
}
