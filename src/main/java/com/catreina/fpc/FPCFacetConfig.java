package com.catreina.fpc;

import com.sucy.skill.api.Settings;
import org.bukkit.entity.Player;

public final class FPCFacetConfig {

  Settings settings;

  FPCFacetConfig(Player p) {

    //

    // Set values for Aspect Facet configuration
    settings.set("dm", 0, 0);
    settings.set("md", 0, 0);

  }
}
