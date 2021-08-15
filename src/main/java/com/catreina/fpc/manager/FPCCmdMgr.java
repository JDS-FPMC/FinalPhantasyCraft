package com.catreina.fpc.manager;

import com.catreina.fpc.FinalPhantasyCraft;
import com.catreina.fpc.commands.CmdConfirmFacetAllocation;
import com.catreina.fpc.commands.CmdResetClass;
import com.catreina.fpc.commands.CmdResetFacetAllocation;
import com.catreina.fpc.commands.CmdSetLinValue;
import com.rit.sucy.commands.CommandManager;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.SenderType;

public class FPCCmdMgr {

  private FinalPhantasyCraft fpc;

  // Constructor
  public FPCCmdMgr(FinalPhantasyCraft fpc) {
    // Save parent class, register commands for plugin
    // through MCCore's 'commands' classes
    this.fpc = fpc;
    this.registerCommands();
  }

  private void registerCommands() {
    // Set up our main commands as /fpc <argument>
    ConfigurableCommand ccRoot = new ConfigurableCommand(fpc, "fpc", SenderType.CONSOLE_ONLY);

    // add some commands to the plugin
    ccRoot.addSubCommand(new ConfigurableCommand(
        fpc, "setLinValue", SenderType.CONSOLE_ONLY, new CmdSetLinValue(),
        "Sets Lin's Facet", "<player> <lin> <facet>", "phantasycraft.aspectconfig"));
    ccRoot.addSubCommand(new ConfigurableCommand(
        fpc, "resetFacetAllocation", SenderType.CONSOLE_ONLY, new CmdResetFacetAllocation(),
        "Resets Lin Allocation Menu", "<player> [aspect]", "phantasycraft.aspectconfig"));
    ccRoot.addSubCommand(new ConfigurableCommand(
        fpc, "confirmFacetAllocation", SenderType.CONSOLE_ONLY, new CmdConfirmFacetAllocation(),
        "Confirms and Applies Facet Allocations", "<player>", "phantasycraft.facetallocation"));
    ccRoot.addSubCommand(new ConfigurableCommand(
        fpc, "resetClass", SenderType.CONSOLE_ONLY, new CmdResetClass(),
        "Forcefully Resets SkillAPI Class", "<player>", "phantasycraft.facetallocation"));

    CommandManager.registerCommand(ccRoot);
  }

}
