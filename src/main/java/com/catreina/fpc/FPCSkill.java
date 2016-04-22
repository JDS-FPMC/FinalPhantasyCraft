package com.catreina.fpc;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.entity.Player;

public final class FPCSkill {

  /*
  int AspectAptitude;
  int AspectCompetence;
  int AspectResilience;
  int AspectGrowth;
  int AspectConviction;
  */

  Player player;
  PlayerData playerData;

  FPCSkill(Player p) {
    // Get Player Data for attribute information
    this.playerData = SkillAPI.getPlayerData(p);
    this.player = p;

    /*
    // Get players attribute values
    AspectAptitude =  playerData.getInvestedAttribute("aptitude");
    AspectResilience =  playerData.getInvestedAttribute("resilience");
    AspectCompetence =  playerData.getInvestedAttribute("competence");
    AspectGrowth =  playerData.getInvestedAttribute("growth");
    AspectConviction =  playerData.getInvestedAttribute("conviction");
    */
  }

  String getAspect(String key) {

    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(key)) {
      return String.valueOf(playerData.getInvestedAttribute(key));
    }
    return "";
  }

  int getAspectVal(String key) {
    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(key)) {
      return playerData.getInvestedAttribute(key);
    }
    return 0;
  }
}
