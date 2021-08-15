package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CerqianEterna extends RPGClass {

  public CerqianEterna() {
    super("Cerqian Eterna", createIconMeta(), 25, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 3,0);
    settings.set("resilience", 2,0);
    settings.set("competence", 0,0);
    settings.set("growth", 1,0);
    settings.set("conviction", -1,0);

    // Set bonus attribute
    settings.set("Technical Acumen", 5, 0);

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
    meta.setDisplayName(ChatColor.RED + " Cerqian Eterna - Technical Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Cerqian Eterna have a deeper");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  connection to the Technical Phase, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  improving their Resilience Facet in ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  return for slightly reduced Spiritual ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  understanding. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Technical Acumen>");
      add(ChatColor.GREEN + "   + 1 Resilience Facet  ");
      add(ChatColor.RED + "   - 1 Conviction Facet  ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
