package me.akitsuki.makoto.events;

import me.akitsuki.makoto.Makoto;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathEventListener implements Listener {
    final private Makoto plugin;

    public PlayerDeathEventListener(Makoto plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (plugin.getConfig().getBoolean("record.death")) {
            Player player = event.getPlayer();

            plugin.getLocHistory().put(player.getUniqueId(), player.getLocation());
        }
    }
}
