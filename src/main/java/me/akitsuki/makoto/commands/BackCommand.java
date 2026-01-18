package me.akitsuki.makoto.commands;

import io.papermc.paper.command.brigadier.CommandSourceStack;
import me.akitsuki.makoto.BaseCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackCommand extends BaseCommand {
    public BackCommand() {
        super("makoto.back");
    }

    @Override
    public void execute(@NotNull CommandSourceStack source, @NotNull String[] args) {
        if (source.getSender() instanceof Player player) {
            // back
            player.sendMessage("Backed to previous location.");
        }
    }
}