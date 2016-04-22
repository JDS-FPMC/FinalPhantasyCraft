package com.catreina.fpc;

import org.bukkit.entity.Player;

public class FPCPlayer {

  private Player player;
  private FPCSkill fpcSkill;


  FPCPlayer(Player p) {

    // TODO: check if player exists in hashmap, add to or update hashmap
    this.player = p;
    this.fpcSkill = new FPCSkill(p);
  }

  Player getPlayer() {
    return player;
  }

  FPCSkill getPlayerSkillData() {
    return fpcSkill;
  }
}
