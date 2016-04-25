package com.catreina.fpc.commands;

import com.catreina.fpc.skillapi.FPCPlayer;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.IFunction;
import com.rit.sucy.version.VersionManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class CmdLinConfig implements IFunction {

  /**
   * Takes Dimensional => Mechanical Lin, sets DM Value
   *  example: /fpc setLin Catreina Dm 4
   *
   * @params
   *
   * @returns
   *
   */

  public void execute(ConfigurableCommand cmd, Plugin plugin, CommandSender s, String[] args) {
    // Players cannot execute these commands
    if (s instanceof Player) {
      return;
    }

    // Console has to send three arguments - player, facetname, facetvalue
    if (args.length != 3) {
      s.sendMessage("usage: " + cmd.getName() + " <player> <lin> <value>");
      return;
    }

    // validate value
    int val;
    try {
      val = Integer.parseInt(args[2]);
      if (val < 0 || val > 8) {
        throw new Exception("Lin value must be between 0 and 8 inclusive.");
      }

    } catch (Exception e) {
      s.sendMessage(args[2] + " is not a valid integer between 0 and 8 inclusive.");
      return;
    }

    // Validate <player> is an online player
    Player player = VersionManager.getPlayer(args[0]);
    if (player == null) {
      s.sendMessage(args[0] + "is not an online player");
      return;
    }

    // Valid player, valid lin value, check lin name
    String lin = args[1];
    FPCPlayer fpcPlayer = new FPCPlayer(player);
    if (!(fpcPlayer.LIN_TYPES.contains(lin.toLowerCase()))) {
      s.sendMessage("Invalid Lin specified: " + lin);
      return;
    }

    // Everything validated - get player attributes
    HashMap<String, Integer> playerAttribs = fpcPlayer.getPlayerData().getAttributeData();

    // Set new values to Lin attributes
    switch (lin.toLowerCase()) {
      case "dm":
        // Player set Dimensional => Mechanical value
        playerAttribs.put("dm", val);
        playerAttribs.put("md", 8 - val);
        break;

      case "md":
        // Player set Mechanical => Dimensional value
        playerAttribs.put("md", val);
        playerAttribs.put("dm", 8 - val);
        break;

      case "ma":
        // Player set Mechanical => Arcane value
        playerAttribs.put("ma", val);
        playerAttribs.put("am", 8 - val);
        break;

      case "am":
        // Player set Arcane => Mechanical value
        playerAttribs.put("am", val);
        playerAttribs.put("ma", 8 - val);
        break;

      case "at":
        // Player set Arcane => Technical value
        playerAttribs.put("at", val);
        playerAttribs.put("ta", 8 - val);
        break;

      case "ta":
        // Player set Technical => Arcane value
        playerAttribs.put("ta", val);
        playerAttribs.put("at", 8 - val);
        break;

      case "ts":
        // Player set Technical => Spiritual value
        playerAttribs.put("ts", val);
        playerAttribs.put("st", 8 - val);
        break;

      case "st":
        // Player set Spiritual => Technical value
        playerAttribs.put("st", val);
        playerAttribs.put("ts", 8 - val);
        break;

      case "sd":
        // Player set Spiritual => Dimensional value
        playerAttribs.put("ds", val);
        playerAttribs.put("sd", 8 - val);
        break;

      case "ds":
        // Player set Dimensional => Spiritual value
        playerAttribs.put("ds", val);
        playerAttribs.put("sd", 8 - val);
        break;
    }
  }
}
