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
    FPCPlayer fpcPlayer;
    FPCSkill fpcSkill;

    if (p == null) return "";

    // Get player data
    fpcPlayer = new FPCPlayer(p);
    fpcSkill = fpcPlayer.getPlayerSkillData();

    String phCategory = id.substring(0, id.indexOf("_"));
    String phValue = id.substring(phCategory.length() + 1);

    switch (phCategory) {
      case "aspect":
        // placeholder: %phantasycraft_aspect_*%
        return fpcSkill.getAspect(phValue);

/*      case "aspectbase":
        // placeholder: %phantasycraft_aspect_*%
        return fpcSkill.getInvestedAspect(phValue);
*/
      case "racelore":
        // placeholder: %phantasycraft_racelore_*%
        return fpcSkill.getRaceLore(phValue.toLowerCase());

      case "raceloredisplayname":
        // placeholder: %phantasycraft_raceloredisplayname_*%
        return fpcSkill.getRaceLoreDisplayName(phValue.toLowerCase());

      default:
        return "UNKNOWN PLACEHOLDER: " + id;
    }
  }
}
