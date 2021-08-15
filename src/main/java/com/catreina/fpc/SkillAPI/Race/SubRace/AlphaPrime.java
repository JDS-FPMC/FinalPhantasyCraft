package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AlphaPrime extends RPGClass {

  public AlphaPrime() {
    super("Alpha Prime Human", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 2, 0);
    settings.set("resilience", 3, 0);
    settings.set("competence", 1, 0);
    settings.set("growth", 0, 0);
    settings.set("conviction", -1, 0);

    // Set bonus attribute
    settings.set("Dimensional Talent", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Human");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Technical Apotheosis");

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " α "  + "Prime Human - Dimensional Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Alpha Prime Humans have embraced the ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " void - that of darkness and light - to help enhance ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " their Technical Phase attunement. In doing so, they ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " have learned how to harness the Dimensional Phase ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " more efficiently, gaining increased Aptitude Facet. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " This has diminished their Spiritual connection, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " further reducing the Alpha Primes Conviction Facet. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Dimensional Talent> ");
      add(ChatColor.GREEN + "   + 1 Aptitude Facet ");
      add(ChatColor.RED + "   - 1 Conviction Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
