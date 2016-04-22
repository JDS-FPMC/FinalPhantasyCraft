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
  public String onPlaceholderRequest(Player p, String string) {
    // Placeholder: %phantasycraft_
    return "";
  }

  public void onEnable() {
    // Fires when minecraft starts up / loads the plugin

  }

  public void onDisable() {
    // Fires when Minecraft shuts down / unloads the plugin

  }

}
