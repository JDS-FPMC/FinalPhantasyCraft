package com.catreina.fpc.commands;

import com.catreina.fpc.skillapi.FPCPlayer;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.IFunction;
import com.rit.sucy.version.VersionManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class CmdResetClass implements IFunction {

  public void execute(ConfigurableCommand cmd, Plugin plugin, CommandSender s, String[] args) {
    // Players cannot execute these commands
    if (s instanceof Player) {
      return;
    }

    // Console has to send one argument - the player that wants to reset to start over
    if (args.length != 1) {
      s.sendMessage("usage: " + cmd.getName() + " <player>");
      return;
    }

    // Validate <player> is an online player
    Player player = VersionManager.getPlayer(args[0]);
    if (player == null) {
      s.sendMessage(args[0] + "is not an online player");
      return;
    }

    // Valid online player. Reset their stats
    FPCPlayer fpcPlayer = new FPCPlayer(player);
    fpcPlayer.getPlayerData().resetAll();
    player.sendMessage("§2You have opted to change your class; §dUnAwakening...");
  }
}
