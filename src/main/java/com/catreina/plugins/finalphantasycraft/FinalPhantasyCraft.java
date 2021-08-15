package com.catreina.plugins.finalphantasycraft;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.SkillPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

/*
  Final Phantasy Craft - Controller

  This plugin is the controller for most of the main functions for Final Phantasy Craft. It
  creates all of the races, sets up the skills, interfaces with DeluxeMenus and PlaceholderAPI
  to set up the Aspect configuration and initial player setup. More may be added, but at
   this time, that is all it is used for.
*/

public final class FinalPhantasyCraft extends JavaPlugin implements SkillPlugin {

  /*=========================================================================
  =
  =  variables that we use throughout the plugin are here -
  =
  =========================================================================*/

  private PluginDescriptionFile pdfFile = getDescription();

  /*=========================================================================
  =
  =  We need to be able to access different values from SkillAPI and set our
  =  Placeholder text with PlaceholderAPI.
  =
  =  We can also see about making an attachment to DeluxeMenus, but that
  =  may be unnecessary so long as our commands are working
  =
  =========================================================================*/


  /*=========================================================================
  =
  =  Set up our SkillAPI Skills and Classes
  =
  =========================================================================*/
  public void registerSkills(SkillAPI api) {}
  public void registerClasses(SkillAPI api) {}


  /*=========================================================================
  =
  =  onEnable and onDisable are below.
  =
  =========================================================================*/
  @Override
  public void onEnable() {
    // Fires when Minecraft loads the plugin

    // TODO: Events when the plugin is loaded

    // print out that we finished enabling the plugin
    getLogger().info("onEnable fired in " + pdfFile.getName());
  }

  @Override
  public void onDisable() {
    // Fires when Mincraft unloads the plugin

    // TODO: Cleanup and finalization

    // print out that we finished disabling the plugin
    getLogger().info("onEnable fired in " + pdfFile.getName());

  }
}
