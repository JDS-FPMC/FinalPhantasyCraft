package com.catreina.fpc;

import com.catreina.fpc.manager.FPCCmdMgr;
import com.catreina.fpc.skillapi.FPCPlayer;
import com.catreina.fpc.skillapi.race.*;
import com.catreina.fpc.skillapi.race.subrace.*;
import com.catreina.fpc.hooks.FPCPlaceholders;
import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.SkillPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/*
  Final Phantasy Craft - Controller

  This plugin is the controller for most of the main functions for Final Phantasy Craft. It
  creates all of the races, sets up the skills, interfaces with DeluxeMenus and PlaceholderAPI
  to set up the Aspect configuration and initial player setup. More may be added, but at
   this time, that is all it is used for.
*/

public final class FinalPhantasyCraft extends JavaPlugin implements Listener, SkillPlugin {

  /*=========================================================================
  =
  =  variables that we use throughout the plugin are here -
  =
  =========================================================================*/

  private PluginDescriptionFile pdfFile = getDescription();
  private String AuthorName = "Catreina";

  /*=========================================================================
  =
  =  Player clicks sign for Aspects
  =     -- "/aspectConfig" issued by player through serversigns
  =     -- permission required:  phantasycraft.aspectConfig
  =        -- this allows us to grant permission to players buying
  =        -- an Aspect reset.
  =
  =     -- After aspectConfig has completed initializing values for the
  =        player, the plugin issues "/dm aspectConfig player" to launch
  =        DeluxeMenus in the players context.
  =
  =========================================================================*/





  /*=========================================================================
  =
  = skillapi interface for classes and skills added to system
  =
  =========================================================================*/

  @Override
  public void registerSkills(SkillAPI skillAPI) {
    // TODO: Add skill
  }

  @Override
  public void registerClasses(SkillAPI skillAPI) {
    // Add the UnAwakened base race
    skillAPI.addClass(new UnAwakened());

    // Add the Cerqians
    skillAPI.addClass(new Cerqian());
    skillAPI.addClass(new CerqianEterna());
    skillAPI.addClass(new VoidCerqian());

    // Add the Espers
    skillAPI.addClass(new Esper());
    skillAPI.addClass(new EsperDeacon());
    skillAPI.addClass(new SpectralEsper());

    // Add the Humans
    skillAPI.addClass(new Human());
    skillAPI.addClass(new AlphaPrime());
    skillAPI.addClass(new OmegaReborn());

    // Add the Cetra
    skillAPI.addClass(new Cetra());
    skillAPI.addClass(new CetraSoothsayer());
    skillAPI.addClass(new CetraIsangoma());

    // Add the Warforged
    skillAPI.addClass(new Warforged());
    skillAPI.addClass(new WarforgedAment());
    skillAPI.addClass(new WarforgedAndroid());

    // TODO: Add classes that races can profess into

  }

  /*=========================================================================
  =
  =  Common functions for plugin information
  =
  =========================================================================*/

  public String getAuthor() {
    return AuthorName;
  }

  public String getPlugin() {
    return pdfFile.getName();
  }

  public String getVersion() {
    return pdfFile.getVersion();
  }

  /*=========================================================================
  =
  =  bukkit/spigot hooks
  =
  =========================================================================*/
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    Player p = event.getPlayer();
    if (p != null) {
      FPCPlayer fpcPlayer = new FPCPlayer(p);
    }
  }

  /*=========================================================================
  =
  =  onEnable and onDisable are below.
  =
  =========================================================================*/
  @Override
  public void onEnable() {
    // Fires when Minecraft loads the plugin

    // Register listener
    getServer().getPluginManager().registerEvents(this, this);

    if (Bukkit.getPluginManager().isPluginEnabled("MCCore")) {
      // So long as skillapi is found, MCCore will be also. We still
      // need to check separately however.
      FPCCmdMgr cmd = new FPCCmdMgr(this);
    }

    // Check for skillapi
    if (!(Bukkit.getPluginManager().isPluginEnabled("skillapi"))) {
      throw new RuntimeException("skillapi not found...");
    }

    // Check for PlaceholderAPI
    if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
      new FPCPlaceholders(this).hook();
    } else {
      throw new RuntimeException("PlaceholderAPI not found...");
    }

    // Get Player Data for all online players
    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
      if (p != null) {
        FPCPlayer fpcPlayer = new FPCPlayer(p);
      }

      // TODO: save player class into hashmap table UUID<==>FPCPlayer instance
    }
  }

  @Override
  public void onDisable() {
    // Fires when Mincraft unloads the plugin

    // TODO: Cleanup and finalization

  }
}
