package com.catreina.fpc.Races;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UnAwakened extends RPGClass {

  // You can set up the icon with descriptive text as well
  private static final ItemStack ICON = new ItemStack(Material.POTION) {{
    ItemMeta meta = ICON.getItemMeta();
    meta.setDisplayName(ChatColor.GOLD + "Alchemist");
    meta.setLore(new ArrayList() {{
      add("");
      add(ChatColor.GRAY + "A hybrid between offense");
      add(ChatColor.GRAY + "and support, the alchemist");
      add(ChatColor.GRAY + "uses potions to apply AOE");
      add(ChatColor.GRAY + "debilitation and healing.");
    }});
    setItemMeta(meta);
  }};

  public UnAwakened() {
    super("UnAwakened", ICON, 1, "race", "");

    settings.set(ClassAttribute.HEALTH, 1, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "UnAwakened");
    setManaName("-");
    setManaRegen(0);

  }

  private static ItemStack createIconMeta() {
    // We have to create the icon meta in the ICON initialization,
    // and the setup on SkillAPI's wiki is not working.
    //
    // So we do it ourselves.
    ItemStack ICON = new ItemStack(Material.SKULL);
    ItemMeta meta = ICON.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "UnAwakened");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "The UnAwakened are the roaming spirits");
      add(ChatColor.GOLD + "that inhabit Velandred. You are one such");
      add(ChatColor.GOLD + "spirit, ready to find your way home, to");
      add(ChatColor.GOLD + "awakened into the world");
      add("");
    }});
    ICON.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return ICON;
  }

  // TODO: Add Skills
}
