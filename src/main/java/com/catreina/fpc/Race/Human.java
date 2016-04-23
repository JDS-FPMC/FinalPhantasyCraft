package com.catreina.fpc.Race;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Human extends RPGClass {

  public Human() {
    super("Human", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 0, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    setPrefix("");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources();

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + " ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Humans are most connected to the Technical ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Aspect, possessing an innate understanding of the ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " nuances within. Coupling this with the dedication ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " and devotion Humans have gives them a much higher ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Resilience Facet. All actions have equal opposing ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " reactions, and Humans are no exception, suffering ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " a lack of understanding for the Spiritual Aspect  ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " and the Arcane Aspect, which result in their lower ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Competence and Aptitude Facet scores. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Bonuses: ");
      add(ChatColor.GREEN + "   + 2 Resilience Facet  ");
      add(ChatColor.RED + "   - 1 Conviction Facet  ");
      add(ChatColor.RED + "   - 1 Growth Facet  ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Ability: "
        + ChatColor.GREEN + "" + ChatColor.BOLD + "Technical Apotheosis");
      add(ChatColor.GRAY + "     - Cooldown of 15 in-game days (5 RL hours)");
      add(ChatColor.GRAY + "     - Elevates the player to immortal status for a short time ");
      add(ChatColor.GRAY + "     - -- All incoming damage to the player is reduced to 0 ");
      add(ChatColor.GRAY + "     - -- Reduces nearby allies damage taken by 50% ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
