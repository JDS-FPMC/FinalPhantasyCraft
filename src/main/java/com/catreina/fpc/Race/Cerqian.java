package com.catreina.fpc.Race;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Cerqian extends RPGClass {

  public Cerqian() {
    super("cerqian", createIconMeta(), 1, "race", "");

    settings.set(ClassAttribute.HEALTH, 0, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    setPrefix("");
    setManaName("-");
    setManaRegen(0);
    setAllowedExpSources();

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + " The Dimensional Aspect - The Cerqians");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      The Cerqian race are likely indigenous to");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  the world of Velandred. They are extremely well");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  attuned with the Dimensional Aspect, and through");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  it, the Arcane and Technical Phase. The Cerqians");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  as a race have little toleracnce for anyone that");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  meddles with the Dimensional Aspect.");
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      Being so highly attuned to the Dimensional");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  Aspect, Cerqians gain +2 Aptitude. This has its");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  drawbacks however, as Cerqians are far removed");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  from the Spiritual and Mechanical Phase, suffering ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "  a -1 penalty to Competence and Conviction.");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Bonuses: ");
      add(ChatColor.GREEN + "   + 2 Aptitude Facet  ");
      add(ChatColor.RED + "   - 1 Competence Facet  ");
      add(ChatColor.RED + "   - 1 Conviction Facet  ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Ability: "
        + ChatColor.GREEN + "" + ChatColor.BOLD + "Dimensional Wavelength");
      add(ChatColor.GRAY + "     - Cooldown of 15 in-game days (5 RL hours)");
      add(ChatColor.GRAY + "     - Stuns all enemies around caster (including bosses)");
      add(ChatColor.GRAY + "     - Removes enemy buffs");
      add(ChatColor.GRAY + "     - Removes ally debuffs");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
