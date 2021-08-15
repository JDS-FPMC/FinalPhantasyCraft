package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SpectralEsper extends RPGClass {

  public SpectralEsper() {
    super("Spectral Esper", createIconMeta(), 25, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 0, 0);
    settings.set("resilience", -1, 0);
    settings.set("competence", 1, 0);
    settings.set("growth", 2, 0);
    settings.set("conviction", 3, 0);

    // Set bonus attribute
    settings.set("Arcane Momentum", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Esper");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Spiritual Reconditioning");

  }

  private static ItemStack createIconMeta() {
    // We have to create the icon meta in the ICON initialization,
    // and the setup on skillapi's wiki is not working.
    //
    // So we do it ourselves.
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " Spectral Esper - Arcane Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Spectral Espers spend intense amounts of");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " time communing with the Arcane Phase, enhancing ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " their Conviction Facet. Because of this however, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " all Spectral Espers have a weakened Resilience ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Facet. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Arcane Momentum> ");
      add(ChatColor.GREEN + "   + 1 Growth Facet ");
      add(ChatColor.RED + "   - 1 Resilience Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
