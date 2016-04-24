package com.catreina.fpc;

import com.catreina.fpc.skillapi.FPCPlayer;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.SenderType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FPCcmd {

  private FinalPhantasyCraft fpc;

  // Constructor
  public FPCcmd(FinalPhantasyCraft fpc) {
    // Save parent class, register commands for plugin
    // through MCCore's 'commands' classes
    this.fpc = fpc;
    this.registerCommands();
  }

  private void registerCommands() {
    // Set up our main commands as /fpc <argument>
    ConfigurableCommand ccRoot = new ConfigurableCommand(fpc, "fpc", SenderType.CONSOLE_ONLY);

    // add some commands to the plugin
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "dm", SenderType.CONSOLE_ONLY, new CmdFacetDm(), "Sets Dimensional => Mechanical Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "ma", SenderType.CONSOLE_ONLY, new CmdFacetMa(), "Sets Mechanical => Arcane Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "at", SenderType.CONSOLE_ONLY, new CmdFacetAt(), "Sets Arcane => Technical Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "ts", SenderType.CONSOLE_ONLY, new CmdFacetTs(), "Sets Technical => Spiritual Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "sd", SenderType.CONSOLE_ONLY, new CmdFacetSd(), "Sets Spiritual => Dimensional Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "ds", SenderType.CONSOLE_ONLY, new CmdFacetDs(), "Sets Dimensional => Spiritual Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "st", SenderType.CONSOLE_ONLY, new CmdFacetSt(), "Sets Spiritual => Technical Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "ta", SenderType.CONSOLE_ONLY, new CmdFacetTa(), "Sets Technical => Arcane Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "am", SenderType.CONSOLE_ONLY, new CmdFacetAm(), "Sets Arcane => Mechanical Lin value", "<number 0-8>"));
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "md", SenderType.CONSOLE_ONLY, new CmdFacetMd(), "Sets Mechanical => Dimensional Lin value", "<number 0-8>"));
  }


  @Override
  public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    // Set up command functionality
    if (cmd.getName().equalsIgnoreCase("AspectConfig")) {
      // Player is asking to configure their aspects - this is our initialization
      if (s instanceof Player) {
        // Cast the sender as a player
        Player p = (Player) s;

        // Get player data
        fpcPlayer = new FPCPlayer(p);
        fpcSkill = fpcPlayer.getPlayerSkillData();

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
