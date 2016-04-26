package com.catreina.fpc.commands;

import com.catreina.fpc.skillapi.FPCPlayer;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.IFunction;
import com.rit.sucy.version.VersionManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class CmdResetFacetAllocation implements IFunction {

  public void execute(ConfigurableCommand cmd, Plugin plugin, CommandSender s, String[] args) {
    // Players cannot execute these commands
    if (s instanceof Player) {
      return;
    }

    // Console has to send one argument - player
    if (args.length > 2 || args.length < 1) {
      return;
    }

    // Validate <player> is an online player
    Player player = VersionManager.getPlayer(args[0]);
    if (player == null) {
      s.sendMessage(args[0] + "is not an online player");
      return;
    }

    // Check aspect argument
    String aspect = "";

    if (args.length == 2) {
      aspect = args[1].toLowerCase();
    }

    // Everything validated - get player attributes
    FPCPlayer fpcPlayer = new FPCPlayer(player);
    HashMap<String, Integer> playerAttribs = fpcPlayer.getPlayerData().getAttributeData();
    int defVal = 4;

    // We have an aspect to reset (the banner was clicked)
    switch (aspect) {
      case "dimensional":
        // If the lin is at < 4, reset it to 4. Do nothing if it is already > 4
        if (playerAttribs.get("dm") < 4) { playerAttribs.put("dm", 4); playerAttribs.put("md", 4); }
        if (playerAttribs.get("ds") < 4) { playerAttribs.put("ds", 4); playerAttribs.put("sd", 4); }
        break;

      case "spiritual":
        // If the lin is at < 4, reset it to 4. Do nothing if it is already > 4
        if (playerAttribs.get("sd") <= 4) { playerAttribs.put("sd", 4); playerAttribs.put("ds", 4); }
        if (playerAttribs.get("st") <= 4) { playerAttribs.put("st", 4); playerAttribs.put("ts", 4); }
        break;

      case "technical":
        // If the lin is at < 4, reset it to 4. Do nothing if it is already > 4
        if (playerAttribs.get("ts") <= 4) { playerAttribs.put("ts", 4); playerAttribs.put("st", 4); }
        if (playerAttribs.get("ta") <= 4) { playerAttribs.put("ta", 4); playerAttribs.put("at", 4); }
        break;

      case "arcane":
        // If the lin is at < 4, reset it to 4. Do nothing if it is already > 4
        if (playerAttribs.get("at") <= 4) { playerAttribs.put("at", 4); playerAttribs.put("ta", 4); }
        if (playerAttribs.get("am") <= 4) { playerAttribs.put("am", 4); playerAttribs.put("ma", 4); }
        break;

      case "mechanical":
        // If the lin is at < 4, reset it to 4. Do nothing if it is already > 4
        if (playerAttribs.get("ma") <= 4) { playerAttribs.put("ma", 4); playerAttribs.put("am", 4); }
        if (playerAttribs.get("md") <= 4) { playerAttribs.put("md", 4); playerAttribs.put("dm", 4); }
        break;

      default:
        // Set new values to Lin attributes
        playerAttribs.put("dm", defVal);
        playerAttribs.put("ds", defVal);
        playerAttribs.put("sd", defVal);
        playerAttribs.put("st", defVal);
        playerAttribs.put("ts", defVal);
        playerAttribs.put("ta", defVal);
        playerAttribs.put("at", defVal);
        playerAttribs.put("am", defVal);
        playerAttribs.put("ma", defVal);
        playerAttribs.put("md", defVal);
    }

    // Now verify that none are over the 8 total for any one Lin
    if (playerAttribs.get("dm") > 8) playerAttribs.put("dm", 4);
    if (playerAttribs.get("ds") > 8) playerAttribs.put("ds", 4);
    if (playerAttribs.get("sd") > 8) playerAttribs.put("sd", 4);
    if (playerAttribs.get("st") > 8) playerAttribs.put("st", 4);
    if (playerAttribs.get("ts") > 8) playerAttribs.put("ts", 4);
    if (playerAttribs.get("ta") > 8) playerAttribs.put("ta", 4);
    if (playerAttribs.get("at") > 8) playerAttribs.put("at", 4);
    if (playerAttribs.get("am") > 8) playerAttribs.put("am", 4);
    if (playerAttribs.get("ma") > 8) playerAttribs.put("ma", 4);
    if (playerAttribs.get("md") > 8) playerAttribs.put("md", 4);
  }
}
