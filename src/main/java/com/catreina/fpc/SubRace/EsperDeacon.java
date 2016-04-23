package com.catreina.fpc.SubRace;

import com.sucy.skill.api.classes.ClassAttribute;
import com.sucy.skill.api.classes.RPGClass;
import com.sucy.skill.api.enums.ExpSource;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EsperDeacon extends RPGClass {

  public EsperDeacon() {
    super("EsperDeacon", createIconMeta(), 25, "race", "UnAwakened");

    settings.set(ClassAttribute.HEALTH, 0, 0);
    settings.set(ClassAttribute.MANA, 0, 0);

    // Set Aspects
    settings.set("Aptitude", -1, 0);
    settings.set("Resilience", 0, 0);
    settings.set("Competence", 2, 0);
    settings.set("Growth", 1, 0);
    settings.set("Conviction", 3, 0);

    // Set bonus attribute
    settings.set("<Mechanical Gain>", 5, 0);

    setPrefix(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "Esper");
    setManaName("Mana");
    setManaRegen(0);
    setAllowedExpSources(ExpSource.MOB, ExpSource.QUEST);

    addSkill("Spiritual Reconditioning");

  }

  private static ItemStack createIconMeta() {
    // We have to create the icon meta in the ICON initialization,
    // and the setup on SkillAPI's wiki is not working.
    //
    // So we do it ourselves.
    // Set up the icon metadata
    ItemStack icon = new ItemStack(Material.BANNER);
    ItemMeta meta = icon.getItemMeta();
    meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + " ");
    meta.setLore(new ArrayList<String>() {{
      add("");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + "      While Spectral Espers focus on the Arcane ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Phase, Esper Deacons opt to assist their ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " people by melding with the Mechanical Phase. ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " Gaining this new insight lowered their capacity ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " for the Dimensional Phase however, ultimately ");
      add(ChatColor.GOLD + "" + ChatColor.ITALIC + " reducing their Aptitude Facet. ");
      add("");
      add(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + " ------------------ ");
      add(ChatColor.AQUA + "" + ChatColor.BOLD + " Racial Bonuses: ");
      add(ChatColor.GREEN + "   + 5  <Mechanical Gain> ");
      add(ChatColor.GREEN + "   + 1 Competence Facet ");
      add(ChatColor.RED + "   - 1 Aptitude Facet ");
    }});
    icon.setItemMeta(meta);

    // And return the ICON to the variable initialization call
    return icon;

  }
}
