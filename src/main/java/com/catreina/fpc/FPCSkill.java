package com.catreina.fpc;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import org.bukkit.entity.Player;

public final class FPCSkill extends SkillAPI {

  public int aspectAptitude;
  public int aspectCompetence;
  public int aspectResilience;
  public int aspectGrowth;
  public int aspectConviction;

  public FPCSkill(Player p) {

    PlayerData playerData = SkillAPI.getPlayerData(p);
    p.sendMessage("Hi there " + playerData.getPlayerName());
    p.sendMessage("You have Aptitude of " + playerData.getAttribute("Aptitude"));
  }

}
