package com.catreina.fpc.commands;

import com.catreina.fpc.skillapi.FPCPlayer;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.IFunction;
import com.rit.sucy.version.VersionManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class CmdConfirmFacetAllocation implements IFunction {

  public void execute(ConfigurableCommand cmd, Plugin plugin, CommandSender s, String[] args) {
    // Players cannot execute these commands
    if (s instanceof Player) {
      return;
    }

    // Console has to send one argument - player
    if (args.length != 1) {
      return;
    }

    // Validate <player> is an online player
    Player player = VersionManager.getPlayer(args[0]);
    if (player == null) {
      s.sendMessage(args[0] + "is not an online player");
      return;
    }

    // Everything validated - get player attributes
    FPCPlayer fpcPlayer = new FPCPlayer(player);
    HashMap<String, Integer> playerAttribs = fpcPlayer.getPlayerData().getAttributeData();

    // Call SkillAPI's upAttribute to add points to each Aspect
    // based on the totals from the Lin values
    // Aptitude - Dimensional Aspect:
    fpcPlayer.getPlayerData().giveAttribute("aptitude", (playerAttribs.get("dm") + playerAttribs.get("ds")));

    // Competence - Mechanical Aspect:
    fpcPlayer.getPlayerData().giveAttribute("competence", (playerAttribs.get("md") + playerAttribs.get("ma")));

    // Growth - Arcane Aspect:
    fpcPlayer.getPlayerData().giveAttribute("growth", (playerAttribs.get("at") + playerAttribs.get("am")));

    // Resilience - Technical Aspect:
    fpcPlayer.getPlayerData().giveAttribute("resilience", (playerAttribs.get("ta") + playerAttribs.get("at")));

    // Conviction - Spiritual Aspect:
    fpcPlayer.getPlayerData().giveAttribute("conviction", (playerAttribs.get("st") + playerAttribs.get("sd")));
  }
}
