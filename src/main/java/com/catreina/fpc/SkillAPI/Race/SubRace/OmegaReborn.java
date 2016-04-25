package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OmegaReborn extends RPGClass {

  public OmegaReborn() {
    super("Omega Reborn Human", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 1, 0);
    settings.set("resilience", 3, 0);
    settings.set("competence", 2, 0);
    settings.set("growth", -1, 0);
    settings.set("conviction", 0, 0);

    // Set bonus attribute
    settings.set("Mechanical Destiny", 5, 0);

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
    meta.setDisplayName(ChatColor.RED + " Ω " + ChatColor.BOLD + "Reborn Human - Dimensional Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Omega Reborn Humans are those who ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " have found peace in the Mechanical Phase, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " granting them increased Competence Facet. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Because of their attention, they have stunted ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " their Arcane Phase connections even further, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " resulting in impeded Growth Facet levels. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Mechanical Destiny> ");
      add(ChatColor.GREEN + "   + 1 Competence Facet ");
      add(ChatColor.RED + "   - 1 Growth Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
