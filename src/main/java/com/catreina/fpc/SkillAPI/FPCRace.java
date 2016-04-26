package com.catreina.fpc.skillapi;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class FPCRace {

  private String BADRACE = "INVALID RACE: ";

  public String getRaceLore(String race) {
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
      return this.invalidRace(race);

    }
  }

  public String getRaceLoreDisplayName(String race) {
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
      return this.invalidRace(race);
    }
  }

  private String invalidRace(String race) {
    return BADRACE + race;
  }
}
