package me.akitsuki.makoto;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public abstract class BaseCommand implements BasicCommand {
    private final String permission;

    public BaseCommand(@Nullable String permission) {
        this.permission = permission;
    }

    @Override
    public @Nullable String permission() {
        return this.permission;
    }

    @Override
    public @NotNull Collection<String> suggest(@NotNull CommandSourceStack source, @NotNull String[] args) {
        return List.of();
    }

    @Override
    public abstract void execute(@NotNull CommandSourceStack source, @NotNull String[] args);
}
