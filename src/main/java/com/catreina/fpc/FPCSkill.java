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
    return "UNK ASPECT: " + aspect;
  }

  String getClassLore(String race){
    // Get the SkillAPI class for the passed race
    // if it doesn't exist, a null is returned to us
    RPGClass iconClass = SkillAPI.getClass(race);
    ItemStack iconClassLore = iconClass.getIcon();
    List iconLore = iconClassLore.getItemMeta().getLore();

    player.sendMessage(iconClassLore.getItemMeta().toString());

    // And send away
    // player.sendMessage(lore);
    return "NO?? ";
/*
    if (iconClass != null) {
      return iconClass.getIcon().getItemMeta().getLore().toString();
    } else {
      return "UNK CLASS: " + race;
    }
*/
  }
}
