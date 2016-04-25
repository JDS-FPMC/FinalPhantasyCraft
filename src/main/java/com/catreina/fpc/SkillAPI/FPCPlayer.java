package com.catreina.fpc.skillapi;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class FPCPlayer {

  private Player player;
  private PlayerData playerData;

  public static final List<String> LIN_TYPES = new ArrayList<String>() {{
    add("dm"); add("ma"); add("at"); add("ts"); add("sd");
    add("md"); add("am"); add("ta"); add("st"); add("ds");
  }};

  public FPCPlayer(Player p) {

    // TODO: check if player exists in hashmap, add to or update hashmap
    // Get Player Data for attribute information
    this.player = p;

    // If we found player data, return true
    this.playerData = SkillAPI.getPlayerData(player);

    // Set default values for lin facet levels
    if (!playerData.getAttributes().containsKey(LIN_TYPES.get(0))) {
      for (String lin : LIN_TYPES) {
        playerData.getAttributeData().put(lin, 4);
      }
    }
  }

  public Player getPlayer() {
    return player;
  }

  public PlayerData getPlayerData() {
    return playerData;
  }

  public String getAspect(String aspect) {
    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(aspect)) {
      return String.valueOf(playerData.getAttribute(aspect));
    }
    return ChatColor.RED + "" + ChatColor.BOLD + "INVALID ASPECT: " + aspect;
  }

  public String getFacetValue(String Lin) {

    Lin = Lin.toLowerCase();

    switch (Lin) {
      // Check for the Dimensional => Mechanical Lin
      case "dm":
      case "dim=>mec":
      case "dimensional=>mechanical":
      case "dimensional => mechanical":
        // Ask skillapi what the Dimensional Facet is
        int dimensional = playerData.getInvestedAttribute("dm");

        // Ask skillapi what the Mechanical Facet is
        int mechanical = playerData.getInvestedAttribute("md");

        // Check that dm + md == 8 --- no more, no less
        if (dimensional + mechanical < 8) {
          // Theres an issue, they do not total 8!!!!! OH NOES!

        } else {
          return Integer.toString(dimensional);
        }
        return "x";

      // Check for the Dimensional => Spiritual Lin
      case "ds":
      case "dim=>spi":
      case "dimensional=>spiritual":
      case "dimensional => spiritual":
        return "x";

      // Check for Spiritual => Technical Lin
      case "st":
      case "spi=>tec":
      case "spiritual=>technical":
      case "spiritual => technical":
        return "x";

      // Check for Spiritual => Dimensional Lin
      case "sd":
      case "spi=>dim":
      case "spiritual=>dimensional":
      case "spiritual => dimensional":
        return "x";

      // Check for the Mechanical => Dimensional Lin
      case "md":
      case "mec=>dim":
      case "mechanical=>dimensional":
      case "mechanical => dimensional":
        return "x";







    }
    return "0";
  }
}
