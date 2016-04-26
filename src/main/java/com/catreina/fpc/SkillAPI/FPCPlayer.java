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

  public static final List<String> ASPECT_TYPES = new ArrayList<String>() {{
    add("aptitude"); // Dimensional Aspect
    add("competence"); // Mechanical Aspect
    add("growth"); // Arcane Aspect
    add("resilience"); // Technical Aspect
    add("conviction"); // Spiritual Aspect
  }};

  public FPCPlayer(Player p) {

    // TODO: check if player exists in hashmap, add to or update hashmap
    // Get Player Data for attribute information
    this.player = p;
    this.playerData = SkillAPI.getPlayerData(player);

    // Set default values for lin facet levels
    for (String lin : LIN_TYPES) {
      if (!playerData.getAttributeData().containsKey(lin)) {
        playerData.getAttributeData().put(lin.toLowerCase(), 4);
      }
    }
  }

  private String invalidValue(String type, String value) {
    return ChatColor.RED + "" + ChatColor.BOLD + "INVALID " + type + " VALUE: " + value;
  }

  public Player getPlayer() {
    return player;
  }

  public PlayerData getPlayerData() {
    return playerData;
  }

  public String getAspect(String aspect) {
    // Set case of 'aspect' to lowercase
    aspect = aspect.toLowerCase();

    // Verify that we are indeed only acquiring an Aspect value
    if (!(ASPECT_TYPES.contains(aspect))) {
      // Player doesn't have the aspect, or the passed value is not an aspect
      return invalidValue("ASPECT", aspect);
    }

    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(aspect)) {
      return String.valueOf(playerData.getAttribute(aspect));
    }

    // Should not get here, but if we do...
    return invalidValue("ASPECT", aspect);
  }

  public String getLinFacetValue(String lin) {
    // Set 'lin' to lowercase for testing
    lin = lin.toLowerCase();

    // Verify that we are acquiring a Lin Facet value
    if (!playerData.getAttributeData().containsKey(lin) || !LIN_TYPES.contains(lin)) {
      // player doesnt have the lin, or the pased value is not a valid lin
      return invalidValue("LIN", lin);
    }

    // Get the lin value
    switch (lin.toLowerCase()) {
      // Check for the Dimensional => Mechanical Lin
      case "dm":
      case "dim=>mec":
      case "dimensional=>mechanical":
      case "dimensional => mechanical":
        // Return the Dimensional => Mechanical Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("dm"));

      // Check for the Mechanical => Dimensional Lin
      case "md":
      case "mec=>dim":
      case "mechanical=>dimensional":
      case "mechanical => dimensional":
        // Return the Mechanical => Dimensional Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("md"));

      // Check for the Arcane => Mechanical Lin
      case "am":
      case "arc=>mec":
      case "arcane=>mechanical":
      case "arcane => mechanical":
        // Return the Arcane => Mechanical Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("am"));

      // Check for the Mechanical => Arcane Lin
      case "ma":
      case "mec=>arc":
      case "mechanical=>arcane":
      case "mechanical => arcane":
        // Return the Mechanical => Arcane Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("ma"));

      // Check for the Arcane => Technical Lin
      case "at":
      case "arc=>tec":
      case "arcane=>technical":
      case "arcane => technical":
        // Return the Arcane => Technical Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("at"));

      // Check for the Technical => Arcane Lin
      case "ta":
      case "tec=>arc":
      case "technical=>arcane":
      case "technical => arcane":
        // Return the Technical => Arcane Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("ta"));

      // Check for the Technical => Spiritual Lin
      case "ts":
      case "tec=>spi":
      case "technical=>spiritual":
      case "technical => spiritual":
        // Return the Technical => Spiritual Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("ts"));

      // Check for the Spiritual => Technical Lin
      case "st":
      case "spi=>tec":
      case "spiritual=>technical":
      case "spiritual => technical":
        // Return the Spiritual => Technical Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("st"));

      // Check for Spiritual => Dimensional Lin
      case "sd":
      case "spi=>dim":
      case "spiritual=>dimensional":
      case "spiritual => dimensional":
        // Return the Spiritual => Dimensional Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("sd"));

      // Check for the Dimensional => Spiritual Lin
      case "ds":
      case "dim=>spi":
      case "dimensional=>spiritual":
      case "dimensional => spiritual":
        // Return the Dimensional => Spiritual Lin Facet value
        return String.valueOf(playerData.getInvestedAttribute("ds"));

      default:
        // Shouldn't get here, but if we do...
        return invalidValue("LIN", lin);
    }
  }

  public String getFacetTotalValue(String aspect) {
    // Set case of 'aspect' to lowercase
    aspect = aspect.toLowerCase();

    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(aspect) && ASPECT_TYPES.contains(aspect)) {
      int linLeft;
      int linRight;

      // Get facet values related to passed aspect
      switch (aspect) {
        case "aptitude":
          linLeft = playerData.getAttribute("dm");
          linRight = playerData.getAttribute("ds");
          break;

        case "conviction":
          linLeft = playerData.getAttribute("sd");
          linRight = playerData.getAttribute("st");
          break;

        case "resilience":
          linLeft = playerData.getAttribute("ts");
          linRight = playerData.getAttribute("ta");
          break;

        case "growth":
          linLeft = playerData.getAttribute("at");
          linRight = playerData.getAttribute("am");
          break;

        case "competence":
          linLeft = playerData.getAttribute("ma");
          linRight = playerData.getAttribute("md");
          break;

        default:
          // There's an error - set a really bad value to show it.
          linLeft = 0;
          linRight = -99999;
      }

      // Add the facet value to the aspect base value and return the result
      return String.valueOf(linLeft + linRight + playerData.getAttribute(aspect));
    }

    // If the aspect wasn't valid, or the player did not have the aspect
    return invalidValue("FACET", aspect);

  }
}

