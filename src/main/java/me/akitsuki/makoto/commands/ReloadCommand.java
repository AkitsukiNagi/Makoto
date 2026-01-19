package me.akitsuki.makoto.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.akitsuki.makoto.BaseCommand;
import me.akitsuki.makoto.Makoto;
import me.akitsuki.makoto.events.PlayerDeathEventListener;
import me.akitsuki.makoto.events.PlayerTeleportEventListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

public class ReloadCommand extends BaseCommand {
    final private Makoto plugin;

    public ReloadCommand(Makoto plugin) {
        super("makoto.reload");
        this.plugin = plugin;
    }

    @Override
    public void execute(@NotNull CommandSourceStack source, @Nullable String[] args) {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        if (plugin.teleportListener != null) {
            plugin.teleportListener = null;
            plugin.teleportListener = new PlayerTeleportEventListener(plugin);
        }
        if (plugin.deathListener != null) {
            plugin.deathListener = null;
            plugin.deathListener = new PlayerDeathEventListener(plugin);
        }

        source.getSender().sendMessage(
                Component.text("[Makoto] ", NamedTextColor.GOLD)
                        .append(Component.text("Configuration reloaded", NamedTextColor.LIGHT_PURPLE))
        );
    }
}
