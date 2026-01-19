package me.akitsuki.makoto.events;

import me.akitsuki.makoto.Makoto;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleportEventListener implements Listener {
    final private Makoto plugin;

    public PlayerTeleportEventListener(Makoto plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        if (plugin.getConfig().getBoolean("record.teleportation")) {
            var player = event.getPlayer();

            plugin.getLocHistory().put(player.getUniqueId(), player.getLocation());
        }
    }
}
