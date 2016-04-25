package com.catreina.fpc.manager;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public final class FPCFacetMgr {

  private int Dm, Ma, At, Ts, Sd;
  private int Ds, St, Ta, Am, Md;

  private UUID pUUID;
  private HashMap<String, Integer> facetVals;

  public FPCFacetMgr(Player p) {
    pUUID = p.getUniqueId();

    if (!facetVals.isEmpty()) {
      // There are values, we are good
    }

  }
}
