package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CetraIsangoma extends RPGClass {

  public CetraIsangoma() {
    super("Cetra Isangoma", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 1, 0);
    settings.set("resilience", -1, 0);
    settings.set("competence", 0, 0);
    settings.set("growth", 3, 0);
    settings.set("conviction", 2, 0);

    // Set bonus attribute
    settings.set("Mechanical Destiny", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Cetra");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Shining Force");

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + " Cetra Isangoma - Mechanical Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Cetra Isangoma are an extremely calm and ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " steadfast people, choosing to focus their energies ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " inward. Drawing on the Spiritual Phase for guidance, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the Isangoma enhance their own faith in all Aspects, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " but at the cost of a reduced Resilience Facet level. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Mechanical Destiny> ");
      add(ChatColor.GREEN + "   + 1 Conviction Facet ");
      add(ChatColor.RED + "   - 1 Resilience Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
