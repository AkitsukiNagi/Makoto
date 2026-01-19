package me.akitsuki.makoto;

import io.papermc.paper.command.brigadier.Commands;
import me.akitsuki.makoto.commands.BackCommand;
import me.akitsuki.makoto.commands.ReloadCommand;
import me.akitsuki.makoto.events.PlayerDeathEventListener;
import me.akitsuki.makoto.events.PlayerTeleportEventListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

import java.util.HashMap;
import java.util.UUID;

public final class Makoto extends JavaPlugin {
    final private HashMap<UUID, Location> LocHistory = new HashMap<>();
    public PlayerTeleportEventListener teleportListener;
    public PlayerDeathEventListener deathListener;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();

            // Register /back command
            BackCommand backCommand = new BackCommand(this);
            ReloadCommand reloadCommand = new ReloadCommand(this);
            commands.register(
                    Commands.literal("back")
                            .requires(source -> source.getSender().hasPermission(backCommand.permission()))
                            .executes(ctx -> {
                                backCommand.execute(ctx.getSource(), new String[0]);
                                return 0;
                            })
                            .build(),
                    "Back to previous location (before transportation or death)"
            );
            commands.register(
                    Commands.literal("makoto")
                            .requires(source -> source.getSender().hasPermission(reloadCommand.permission()))
                            .then(Commands.literal("reload")
                                    .requires(source -> source.getSender().hasPermission(reloadCommand.permission()))
                                    .executes(ctx -> {
                                        reloadCommand.execute(ctx.getSource(), new String[0]);
                                        return 0;
                                    })
                            )
                            .executes(ctx -> {
                                ctx.getSource().getSender().sendMessage(
                                        Component.text("Use /makoto reload to reload configs.", NamedTextColor.RED)
                                );
                                return 0;
                            })
                            .build(),
                    "Root command of Makoto"
            );
        });

        teleportListener = new PlayerTeleportEventListener(this);
        deathListener = new PlayerDeathEventListener(this);

        getServer().getPluginManager().registerEvents(teleportListener, this);
        getServer().getPluginManager().registerEvents(deathListener, this);
        log(Component.text("The plugin has enabled", NamedTextColor.GREEN));
    }

    @Override
    public void onDisable() {
        log(Component.text("The plugin has disabled.", NamedTextColor.RED));
    }

    public HashMap<UUID, Location> getLocHistory() {
        return LocHistory;
    }

    public void log(Component component) {
        getServer().getConsoleSender().sendMessage(Component.text("[Makoto] ", NamedTextColor.GOLD).append(component));
    }
}
