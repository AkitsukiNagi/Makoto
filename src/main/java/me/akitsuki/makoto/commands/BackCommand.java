package me.akitsuki.makoto.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.akitsuki.makoto.BaseCommand;
import me.akitsuki.makoto.Makoto;
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
            player.teleport(plugin.getLocHistory().get(player.getUniqueId()));
            player.sendMessage("Backed to previous location.");
        }
    }
}