package com.catreina.fpc.skillapi.race;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UnAwakened extends RPGClass {

  public UnAwakened() {
    super("UnAwakened", CreateIcon(), 1, "race", "");

    // Set default health and mana
    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects to zero
    settings.set("aptitude", 1, 0);
    settings.set("resilience", 1, 0);
    settings.set("competence", 1, 0);
    settings.set("growth", 1, 0);
    settings.set("conviction", 1, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "UnAwakened");
    setManaName("-");
    setManaRegen(0);

    addSkills(
      "Active skill Bonuses",
      "Area of Effect",
      "Battlefield Manipulation",
      "Cooldown Reduction",
      "Critical Hit",
      "Regeneration"
    );
  }

  static final ItemStack CreateIcon() {
    // Set up the icon metadata
    ItemStack iconLore = new ItemStack(Material.SKULL);
    ItemMeta meta = iconLore.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " - The UnAwakened");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " The UnAwakened are the roaming spirits");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " that inhabit Velandred. You are one such ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " spirit - ready to find your way home; ready ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " to be brought, awakened, into the world");
    }});
    iconLore.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return iconLore;
  }
}
