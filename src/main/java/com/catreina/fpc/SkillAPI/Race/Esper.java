package com.catreina.fpc.skillapi.race;

import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Esper extends RPGClass {

  public Esper() {
    super("Esper", createIconMeta(), 10, "race", "");

    setPrefix("");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources();

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " The Spiritual Aspect - Espers ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Esper people were torn from Lemaeyre - a");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " world where all existed in perfect harmony. While");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " While the two sub-races, the Spectral Espers and");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the Esper Deacons, were not always in agreement,");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " all things - the people, plants, animals, and even");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the geology - sang to the beat of one drum: the");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Spiritual Aspect. ");
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Extremely Spiritual beings, Espers are uniquely ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " attuned with the Spiritual Aspect and gain a bonus");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " of +2 to the Conviction Facet. As all things, this");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " comes at a cost; Espers are steadfastly against ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " any connections to the Technical or Dimensional Phase ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Bonuses: ");
      add(ChatColor.GREEN + "   + 2 Conviction Facet  ");
      add(ChatColor.RED + "   - 1 Aptitude Facet  ");
      add(ChatColor.RED + "   - 1 Resilience Facet  ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Ability: "
        + ChatColor.GREEN + "" + ChatColor.BOLD + "Spiritual Reconditioning");
      add(ChatColor.GRAY + "     - Cooldown of 15 in-game days (5 RL hours)");
      add(ChatColor.GRAY + "     - Increases damage taken for all affected enemies");
      add(ChatColor.GRAY + "     - Drastically increases allies skill defenses ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
