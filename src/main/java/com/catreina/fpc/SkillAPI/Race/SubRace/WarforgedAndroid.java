package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WarforgedAndroid extends RPGClass {

  public WarforgedAndroid() {
    super("Warforged Android", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", -0, 0);
    settings.set("resilience", 2, 0);
    settings.set("competence", 3, 0);
    settings.set("growth", -1, 0);
    settings.set("conviction", 1, 0);

    // Set bonus attribute
    settings.set("Technical Momentum", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Warforged");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Force Synthesis");

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + " Warforged Android - Technical Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Technical Phase was tapped when many Warforged ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " were created, culminating in the Androids. These beings ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " are thus more aligned with the Technical Phase, resulting ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " in a higher Resilience Facet level, but suffering from a ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " reduced Growth Facet level. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Technical Momentum> ");
      add(ChatColor.GREEN + "   + 1 Resilience Facet ");
      add(ChatColor.RED + "   - 1 Growth Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
