package com.catreina.fpc;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FPCSkill {

  private Player player;
  private PlayerData playerData;

  FPCSkill(Player p) {
    // Get Player Data for attribute information
    this.player = p;
    SetPlayerData();
  }

  private void SetPlayerData() {
    // If we found player data, return true
    this.playerData = SkillAPI.getPlayerData(player);
  }

  String getAspect(String aspect) {
    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(aspect)) {
      return String.valueOf(playerData.getAttribute(aspect));
    }
    return "INVALID ASPECT: " + aspect;
  }

  String getRaceLore(String race) {
    // Get the icon associated with passed "race" value

    RPGClass rpgClass;
    if (SkillAPI.isClassRegistered(race)) {
      rpgClass = SkillAPI.getClass(race);

      ItemStack itemStack = rpgClass.getIcon();
      String lore = "";

      // Make sure the Class Lore actually has metadata and lore
      if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
        List<String> iconLore = itemStack.getItemMeta().getLore();

        // We have lore. Replace color code numbers
        // iconLore.replaceAll(s -> ChatColor.translateAlternateColorCodes('&', s));

        for (String line : iconLore) {
          lore = lore + line + "\n";
        }

      }
      // And send it back
      return lore;

    } else {
      // Passed class is not a valid race
      return "INVALID RACE: " + race;

    }
  }

  String getRaceLoreDisplayName(String race) {
    // Get the class icon associated with passed "race" value
    if (SkillAPI.isClassRegistered(race)) {
      RPGClass rpgClass = SkillAPI.getClass(race);
      ItemStack itemStack = rpgClass.getIcon();

      // Initialize displayName
      String displayName = "";

      // Make sure the Class Lore actually has metadata and lore
      if (itemStack.hasItemMeta()) {
        displayName = itemStack.getItemMeta().getDisplayName();
      }

      // And send it back
      return displayName;
    } else {
      return "INVALID RACE: " + race;
    }
  }
}
