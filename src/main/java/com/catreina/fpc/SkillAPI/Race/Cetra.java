package com.catreina.fpc.skillapi.race;

import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Cetra extends RPGClass {

  public Cetra() {
    super("Cetra", createIconMeta(), 10, "race", "");

    setPrefix("");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources();

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " The Arcane Aspect - Cetra ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Born of, and being highly attuned to the Arcane ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Aspect, the Cetra are a peaceful but powerful race. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Having an understanding of the 'art of understanding,' ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " the Cetra have all but mastered their connection to the ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Growth Phase. Being born of the Arcane Aspect has its ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " disadvantages however, as the Mechanical and Technical ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Aspects compete with the Arcane, resulting in lowered ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Resilience and Competence Facet for all Cetra.");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Bonuses: ");
      add(ChatColor.GREEN + "   + 2 Growth Facet ");
      add(ChatColor.RED + "   - 1 Resilience Facet ");
      add(ChatColor.RED + "   - 1 Competence Facet ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Ability: "
        + ChatColor.GREEN + "" + ChatColor.BOLD + "Shining Force");
      add(ChatColor.GRAY + "     - Cooldown of 15 in-game days (5 RL hours)");
      add(ChatColor.GRAY + "     - Drastically increases allies health regeneration ");
      add(ChatColor.GRAY + "     - Drastically increases allies skill critical damage ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
