package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class WarforgedAment extends RPGClass {

  public WarforgedAment() {
    super("Warforged Ament", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", -1, 0);
    settings.set("resilience", 1, 0);
    settings.set("competence", 3, 0);
    settings.set("growth", 0, 0);
    settings.set("conviction", 2, 0);

    // Set bonus attribute
    settings.set("Spiritual Talent", 5, 0);

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
    meta.setDisplayName(ChatColor.RED + "" + " Warforged Ament - Spiritual Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Once organic, their creators deemed the hosts ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " of these people suitable for "
        + ChatColor.UNDERLINE + "recombination" + ChatColor.GOLD + "" + ChatColor.ITALIC + " Thus, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the Warforged Ament were born - a crossing ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " of the Spiritual Phase with the Mechanical ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Aspect. Warforged Ament are empowered with a");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " higher Conviction Facet level, though due to ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the conditions surrounding their creation, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Warforged Ament also have a substandard Aptitude ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Facet level. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Spiritual Talent> ");
      add(ChatColor.GREEN + "   + 1 Conviction Facet ");
      add(ChatColor.RED + "   - 1 Aptitude Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
