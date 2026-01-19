package me.akitsuki.makoto.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.akitsuki.makoto.BaseCommand;
import me.akitsuki.makoto.Makoto;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackCommand extends BaseCommand {
    private final Makoto plugin;

    public BackCommand(Makoto plugin) {
        super("makoto.back");

        this.plugin = plugin;
    }

    @Override
    public void execute(@NotNull CommandSourceStack source, @NotNull String[] args) {
        if (source.getSender() instanceof Player player) {
            Location pLocation = plugin.getLocHistory().get(player.getUniqueId());

            if (pLocation == null) {
                player.sendMessage(Component.text("Previous location not found.", NamedTextColor.RED));
            } else {
                player.teleport(pLocation);
                player.sendMessage(Component.text("Backed to previous location.", NamedTextColor.GOLD));
            }
        }
    }
}