package com.catreina.fpc.SubRace;

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

    settings.set(ClassAttribute.HEALTH, 0, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("Aptitude", 3,0);
    settings.set("Resilience", 1,0);
    settings.set("Competence", -1,0);
    settings.set("Growth", 2,0);
    settings.set("Conviction", 0,0);

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
    // and the setup on SkillAPI's wiki is not working.
    //
    // So we do it ourselves.
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + " Void Cerqian - Arcane Phase");
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
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Arcane Destiny>");
      add(ChatColor.GREEN + "   + 1 Growth Facet  ");
      add(ChatColor.RED + "   - 1 Competence Facet  ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
