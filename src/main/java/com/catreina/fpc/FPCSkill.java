package com.catreina.fpc;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.entity.Player;

public class FPCSkill {

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
    this.player = p;
    SetPlayerData(p);

    /*
    // Get players attribute values
    AspectAptitude =  playerData.getInvestedAttribute("aptitude");
    AspectResilience =  playerData.getInvestedAttribute("resilience");
    AspectCompetence =  playerData.getInvestedAttribute("competence");
    AspectGrowth =  playerData.getInvestedAttribute("growth");
    AspectConviction =  playerData.getInvestedAttribute("conviction");
    */
  }

   private void SetPlayerData(Player p) {
    // If we found player data, return true
    this.playerData = SkillAPI.getPlayerData(p);
  }

  String getInvestedAspect(String key) {

    // Gets the aspect related to the passed key
    if (playerData.hasAttribute(key)) {
      player.sendMessage("Checking for " + key + " -- " + playerData.getPlayerName());
      return String.valueOf(playerData.getInvestedAttribute(key));
    }
    return "";
  }
}
