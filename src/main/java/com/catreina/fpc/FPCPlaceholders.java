package com.catreina.fpc;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public final class FPCPlaceholders extends EZPlaceholderHook {

  private FinalPhantasyCraft fpc;

  public FPCPlaceholders(FinalPhantasyCraft fpc) {
    // Registering the fpc placeholder
    super(fpc, "phantasycraft");

    // Give ability to use the main class in this class
    this.fpc = fpc;
  }

  @Override
  public String onPlaceholderRequest(Player p, String id) {
    // Get SkillAPI information
    FPCSkill fpcSkill = fpc.fpcSkill;

    if (p == null) return "";

    // placeholder: %phantasycraft_aspect_aptitude%
    if (id.equals("aspect_aptitude")) {
      p.sendMessage("sending getAspect(\"" + id + "\")");

      return String.valueOf(fpcSkill.getAspect("aptitude"));
    }

    // placeholder: %phantasycraft_aspect_resilience%
    if (id.equals("aspect_resilience")) {
      return String.valueOf(fpcSkill.getAspect("resilience"));
    }

    // placeholder: %phantasycraft_aspect_competence%
    if (id.equals("aspect_competence")) {
      return String.valueOf(fpcSkill.getAspect("competence"));
    }

    // placeholder: %phantasycraft_aspect_aptitude%
    if (id.equals("aspect_growth")) {
      return String.valueOf(fpcSkill.getAspect("Growth"));
    }

    // placeholder: %phantasycraft_aspect_conviction%
    if (id.equals("aspect_conviction")) {
      return String.valueOf(fpcSkill.getAspect("conviction"));
    }

    return "Unknown Placeholder: " + id;
  }
}
