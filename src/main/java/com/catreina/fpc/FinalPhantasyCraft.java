package com.catreina.fpc;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/*
  Final Phantasy Craft - Controller

  This plugin is the controller for most of the main functions for Final Phantasy Craft. It
  creates all of the races, sets up the skills, interfaces with DeluxeMenus and PlaceholderAPI
  to set up the Aspect configuration and initial player setup. More may be added, but at
   this time, that is all it is used for.
*/

public final class FinalPhantasyCraft extends JavaPlugin {

  /*=========================================================================
  =
  =  variables that we use throughout the plugin are here -
  =
  =========================================================================*/

  private PluginDescriptionFile pdfFile = getDescription();
  private String AuthorName = "Catreina";

  public FPCSkill fpcSkill;

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







  public boolean GetSkillAPIData(Player p) {
    // If we found player data, return true
    this.fpcSkill = new FPCSkill(p);

    return true;
  }
  /*=========================================================================
  =
  =
  =
  =========================================================================*/


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
  =  onEnable and onDisable are below.
  =
  =========================================================================*/
  @Override
  public void onEnable() {
    // Fires when Minecraft loads the plugin

    // Need to register a listener, so we can do our thing
    this.getCommand("aspectConfig").setExecutor(new FPCcmd(this));

    // TODO: Events when the plugin is loaded


    // print out that we finished enabling the plugin
    getLogger().info("onEnable fired in " + pdfFile.getName());
  }

  @Override
  public void onDisable() {
    // Fires when Mincraft unloads the plugin

    // TODO: Cleanup and finalization

    // print out that we finished disabling the plugin
    getLogger().info("onDisable fired in " + pdfFile.getName());

  }
}
