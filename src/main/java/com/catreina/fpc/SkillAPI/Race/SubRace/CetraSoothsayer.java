package com.catreina.fpc.skillapi.race.subrace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CetraSoothsayer extends RPGClass {

  public CetraSoothsayer() {
    super("Cetra Soothsayer", createIconMeta(), 10, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 5, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("aptitude", 2, 0);
    settings.set("resilience", 0, 0);
    settings.set("competence", -1, 0);
    settings.set("growth", 3, 0);
    settings.set("conviction", 1, 0);

    // Set bonus attribute
    settings.set("dimensional gain", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Cetra");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Shining Force");

  }

  private static ItemStack createIconMeta() {
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + " Cetra Soothsayer - Dimensional Phase ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      There are some Cetra who can mold their ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " abilities further than what should be possible. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " These Cetra use not only their Arcane Aspect skills, ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " but also draw on the Dimensional Phase to empower ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " them. Through their use of this connection, they have ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " further enhanced their Aptitude Facet levels at a ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " cost of their Competence Facet - the work area of a  ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Cetra Soothsayer is not the safest place to be. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Additional Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Dimensional Gain> ");
      add(ChatColor.GREEN + "   + 1 Aptitude Facet ");
      add(ChatColor.RED + "   - 1 Competence Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
