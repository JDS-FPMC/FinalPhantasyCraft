package com.catreina.fpc.skillapi.race;

import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Warforged extends RPGClass {

  public Warforged() {
    super("Warforged", createIconMeta(), 10, "race", "");

    setPrefix("");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources();

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " The Mechanical Aspect - Warforged ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Warforged are unique in that they are beings ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " created of and directly from the Mechanical Aspect, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " as opposed to being born of it. As such, they do not ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " focus their time or energies on attunement - they are ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " naturally attuned, a physical manifestation of the ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Mechanical Aspect itself. This natural attunement comes ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " with drawbacks for those who are the Mechanical Aspect");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " incarnate: a reduced capacity for the Growth and Aptitude ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Facet, stemming from constant conflict with both the ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Dimensional and Arcane Aspects. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Bonuses: ");
      add(ChatColor.GREEN + "   + 2 Competence Facet ");
      add(ChatColor.RED + "   - 1 Aptitude Facet ");
      add(ChatColor.RED + "   - 1 Growth Facet ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Ability: "
        + ChatColor.GREEN + "" + ChatColor.BOLD + "Force Synthesis");
      add(ChatColor.GRAY + "     - Cooldown of 15 in-game days (5 RL hours)");
      add(ChatColor.GRAY + "     - Increases allies physical damage ");
      add(ChatColor.GRAY + "     - Reduces allies received physical damage by 50% ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
