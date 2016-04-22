package com.catreina.fpc;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public class FPCPlaceholders extends EZPlaceholderHook {

  private FinalPhantasyCraft fpc;

  public FPCPlaceholders(FinalPhantasyCraft fpc) {
    // Registering the fpc placeholder
    super(fpc, "phantasycraft");

    // Give ability to use the main class in this class
    this.fpc = fpc;
  }

  @Override
  public String onPlaceholderRequest(Player p, String id) {
    if (p == null) return "";

    // Get SkillAPI information
    FPCSkill fpcSkill = new FPCSkill(p);

    // placeholder: %phantasycraft_aspect_aptitude%
    if (id.equals("aspect_aptitude")) {
      return fpcSkill.getInvestedAspect("aptitude");
    }

    // placeholder: %phantasycraft_aspect_resilience%
    if (id.equals("aspect_resilience")) {
      return fpcSkill.getInvestedAspect("resilience");
    }

    // placeholder: %phantasycraft_aspect_competence%
    if (id.equals("aspect_competence")) {
      return fpcSkill.getInvestedAspect("competence");
    }

    // placeholder: %phantasycraft_aspect_aptitude%
    if (id.equals("aspect_growth")) {
      return fpcSkill.getInvestedAspect("Growth");
    }

    // placeholder: %phantasycraft_aspect_conviction%
    if (id.equals("aspect_conviction")) {
      return fpcSkill.getInvestedAspect("conviction");
    }

    return "Unknown Placeholder: " + id;
  }
}
