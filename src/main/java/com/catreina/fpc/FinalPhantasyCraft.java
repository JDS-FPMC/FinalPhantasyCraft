package com.catreina.fpc;

import com.catreina.fpc.SubRace.CerqianEterna;
import com.catreina.fpc.SubRace.VoidCerqian;
import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.SkillPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.catreina.fpc.Race.Cerqian;
import com.catreina.fpc.Race.UnAwakened;

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
  = SkillAPI interface for classes and skills added to system
  =
  =========================================================================*/

  @Override
  public void registerSkills(SkillAPI skillAPI) {
    // TODO: Add Skills
  }

  @Override
  public void registerClasses(SkillAPI skillAPI) {
    // TODO: Add classes
    skillAPI.addClass(new UnAwakened());
    skillAPI.addClass(new Cerqian());
    skillAPI.addClass(new CerqianEterna());
    skillAPI.addClass(new VoidCerqian());

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

    // Need to register a listener, so we can do our thing
    this.getCommand("aspectConfig").setExecutor(new FPCcmd(this));

    // Check for PlaceholderAPI
    if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
      new FPCPlaceholders(this).hook();
    } else {
      throw new RuntimeException("PlaceholderAPI not found...");
    }

    // Check for SkillAPI
    if (!(Bukkit.getPluginManager().isPluginEnabled("SkillAPI"))) {
      throw new RuntimeException("SkillAPI not found...");
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

    // print out that we finished disabling the plugin
    getLogger().info("onDisable fired in " + pdfFile.getName());

  }
}
