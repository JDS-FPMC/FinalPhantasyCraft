package com.catreina.fpc.hooks;

import com.catreina.fpc.FinalPhantasyCraft;
import com.catreina.fpc.skillapi.FPCPlayer;
import com.catreina.fpc.skillapi.FPCRace;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public class FPCPlaceholders extends EZPlaceholderHook {

  private FinalPhantasyCraft fpc;
  private FPCPlayer fpcPlayer;

  public FPCPlaceholders(FinalPhantasyCraft fpc) {
    // Registering the fpc placeholder
    super(fpc, "phantasycraft");

    // Give ability to use the main class in this class
    this.fpc = fpc;
  }

  @Override
  public String onPlaceholderRequest(Player p, String id) {
    if (p == null) return "";

    // Get player data
    fpcPlayer = new FPCPlayer(p);
    FPCRace fpcRace = new FPCRace();

    String phCategory = (id.contains("_") ? id.substring(0, id.indexOf("_")) : id);
    String phValue = (id.contains("_") ? id.substring(phCategory.length() + 1) : "");

    switch (phCategory) {
      // Get players name
      case "playername":
        return fpcPlayer.getPlayer().getName();

      // Get SkillAPI Player Information
      case "aspect":
        // placeholder: %phantasycraft_aspect_*%
        return fpcPlayer.getAspect(phValue);

      case "linfacetvalue":
        // placeholder: %phantasycraft_linfacetvalue_*%
        return fpcPlayer.getLinFacetValue(phValue.toLowerCase());

      case "facettotalvalue":
        // placeholder: %phantasycraft_facettotalvalue_*%
        return fpcPlayer.getFacetTotalValue(phValue.toLowerCase());

      // Get SkillAPI Race Information
      case "racelore":
        // placeholder: %phantasycraft_racelore_*%
        return fpcRace.getRaceLore(phValue.toLowerCase());

      case "raceloredisplayname":
        // placeholder: %phantasycraft_raceloredisplayname_*%
        return fpcRace.getRaceLoreDisplayName(phValue.toLowerCase());

      default:
        return "UNKNOWN PLACEHOLDER: " + id;
    }
  }
}
