package com.catreina.fpc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FPCcmd implements CommandExecutor {

  private FinalPhantasyCraft fpc;
  private FPCPlayer fpcPlayer;
  private FPCSkill fpcSkill;

  // Constructor
  public FPCcmd(FinalPhantasyCraft fpc) {
    // Store plugin main class so we can use it in this class
    this.fpc = fpc;
  }

  @Override
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    // Set up command functionality
    if (cmd.getName().equalsIgnoreCase("AspectConfig")) {
      // Player is asking to configure their aspects - this is our initialization
      if (s instanceof Player) {
        // Cast the sender as a player
        Player p = (Player) s;

        p.sendMessage("You have " + fpcSkill.getAspect("Aptitude") + " Aptitude");

        // The only time a player can use /aspectConfig is if they have the assigned permission
        if (!p.hasPermission("phantasycraft.aspectconfig")) {
          // No permission
          p.sendMessage("You do not have access to " + cmd + " (permission missing: PhantasyCraft.AspectConfig");
          return true;
        } else {
          // They have permission, continue with setup

          p.sendMessage("You have permission!");
          return true;
        }

      } else {
        // TODO: Console configuration on /aspectConfig

        // For now, return an error if the sender is not a logged-in player
        s.sendMessage("Only a logged-in player may access '" + cmd.getName() + "'");
        return true;
      }
    }

    // We were passed a command sender, with no valid command
    return false;
  }

}
