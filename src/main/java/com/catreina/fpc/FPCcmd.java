package com.catreina.fpc;

import com.catreina.fpc.commands.CmdLinConfig;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.SenderType;

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
    ccRoot.addSubCommand(new ConfigurableCommand(fpc, "setLinValue", SenderType.CONSOLE_ONLY,
        new CmdLinConfig(), "Sets a Lin's Facet value.", "<player> <lin> <facet>", "phantasycraft.aspectconfig"));
  }

}
