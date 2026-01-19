# Makoto
Makoto is japanese name "誠", which means loyal.

I think the plugin will be your loyal friend to take you back to the previous location.

## Usage
Everything is under permission's control, so I recommend you to install [LuckPerms](https://luckperms.net/).

### Back to previous location
Player with permission `makoto.back` are able to use `/back` command, which can take them to previous location.

### Reload config
Player with permission `makoto.reload` are able to reload configuration using `/makoto reload` command.

## Configuration
The configuration file is very easy, there's only two options.
```yaml
record:
  death: true
  teleportation: true
```

`death` records player's death location, which means players can back to the location where they died.

Similarly, `teleportation` controls whether the plugin to log the player's old location when they use teleport commands like `tp`, `warp` (command created by other plugins), etc.

## Todo
* [ ] Make `death` and `teleportation` also controlled by permissions.
