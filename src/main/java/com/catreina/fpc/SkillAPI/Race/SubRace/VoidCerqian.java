package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class VoidCerqian extends RPGClass {

  public VoidCerqian() {
    super("Void Cerqian", createIconMeta(), 25, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 3,0);
    settings.set("resilience", 1,0);
    settings.set("competence", -1,0);
    settings.set("growth", 2,0);
    settings.set("conviction", 0,0);

    // Set bonus attribute
    settings.set("Arcane Destiny", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Cerqian");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Dimensional Wavelength");

  }

  private static ItemStack createIconMeta() {
    // We have to create the icon meta in the ICON initialization,
    // and the setup on skillapi's wiki is not working.
    //
    // So we do it ourselves.
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " Void Cerqian - Arcane Phase");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Void Cerqians have focused on ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Arcane Phase aptitude, choosing to spend ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " more time tinkering or experimenting. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " This succeeded in enhancing their ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Conviction, yet it has resulted in ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " an overall reduction in Competence. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Arcane Destiny>");
      add(ChatColor.GREEN + "   + 1 Growth Facet  ");
      add(ChatColor.RED + "   - 1 Competence Facet  ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
