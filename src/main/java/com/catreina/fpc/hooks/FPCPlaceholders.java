package com.catreina.fpc.hooks;

import com.catreina.fpc.FinalPhantasyCraft;
import com.catreina.fpc.skillapi.FPCPlayer;
import com.catreina.fpc.skillapi.FPCRace;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public class FPCPlaceholders extends EZPlaceholderHook {

  private FinalPhantasyCraft fpc;
  private FPCRace fpcRace;

  private String UNKPLACEHOLDER = "UNKNOWN PLACEHOLDER: ";

  public FPCPlaceholders(FinalPhantasyCraft fpc) {
    // Registering the fpc placeholder
    super(fpc, "phantasycraft");

    // Give ability to use the main class in this class
    this.fpc = fpc;
  }

  @Override
  public String onPlaceholderRequest(Player p, String id) {
    FPCPlayer fpcPlayer;

    if (p == null) return "";

    // Get player data
    fpcPlayer = new FPCPlayer(p);

    String phCategory = id.substring(0, id.indexOf("_"));
    String phValue = id.substring(phCategory.length() + 1);

    switch (phCategory) {
      case "aspect":
        // placeholder: %phantasycraft_aspect_*%
        return fpcPlayer.getAspect(phValue);

      case "facetsetup":
        // placeholder: %phantasycraft_facetsetup_*%
        return fpcPlayer.getFacetValue(phValue);

      case "racelore":
        // placeholder: %phantasycraft_racelore_*%
        return fpcRace.getRaceLore(phValue.toLowerCase());

      case "raceloredisplayname":
        // placeholder: %phantasycraft_raceloredisplayname_*%
        return fpcRace.getRaceLoreDisplayName(phValue.toLowerCase());

      default:
        return UNKPLACEHOLDER + id;
    }
  }
}
