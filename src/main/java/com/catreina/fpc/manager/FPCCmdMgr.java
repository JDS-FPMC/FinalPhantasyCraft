package com.catreina.fpc.manager;

import com.catreina.fpc.FinalPhantasyCraft;
import com.catreina.fpc.commands.CmdLinConfig;
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
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "setLinValue", SenderType.CONSOLE_ONLY,
        new CmdLinConfig(), "Sets a Lin's Facet value.", "<player> <lin> <facet>", "phantasycraft.aspectconfig"));
  }

}
