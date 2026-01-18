package me.akitsuki.makoto;

import io.papermc.paper.command.brigadier.Commands;
import me.akitsuki.makoto.commands.BackCommand;
import me.akitsuki.makoto.events.PlayerTransportEventListener;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

import java.util.HashMap;
import java.util.UUID;

public final class Makoto extends JavaPlugin {
    final private HashMap<UUID, Location> LocHistory = new HashMap<>();

    @Override
    public void onEnable() {
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            int commandCount = 0;

            // Register /back command
            BackCommand backCommand = new BackCommand(this);

            commands.register("back", "Back to previous location", backCommand);
            commandCount += 1;
            getServer().getPluginManager().registerEvents(new PlayerTransportEventListener(this), this);

            log(String.format("<green>Registered %d commands</green>", commandCount));
        });
    }

    @Override
    public void onDisable() {
        log("<red>Disabled</red>");
    }

    public HashMap<UUID, Location> getLocHistory() {
        return LocHistory;
    }

    public void log(String message) {
        getServer().getConsoleSender().sendMessage("<#248b9d>[Makoto]</#248b9d>" + ' ' + message);
    }
}
