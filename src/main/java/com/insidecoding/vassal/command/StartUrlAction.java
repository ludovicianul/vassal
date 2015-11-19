package com.insidecoding.vassal.command;

import java.awt.Desktop;
import java.io.PrintWriter;
import java.net.URI;

/**
 * Opens an URL using the default browser.
 * 
 * @author milie
 *
 */
public class StartUrlAction extends VassalInteractiveAction {

	@Override
	public void doLogic(PrintWriter writer, String... args) throws Exception {
		StringBuilder param = new StringBuilder();

		for (int i = 0; i < args.length; i++) {
			param.append(args[i]).append(" ");
		}
		Desktop.getDesktop().browse(
				new URI(param.toString().trim().replaceAll(" ", "%20")));
	}

	@Override
	public String getCommandName() {
		return "URL";
	}

}
