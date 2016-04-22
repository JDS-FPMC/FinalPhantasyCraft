package com.catreina.fpc.Races;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class cerqian extends RPGClass {

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

  public cerqian() {
    super("The Cerqians", ICON, 1, "race", "");

    settings.set(ClassAttribute.HEALTH, 0, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    setPrefix("");
    setManaName("-");
    setManaRegen(0);

    // TODO: Add Skills

  }
}
