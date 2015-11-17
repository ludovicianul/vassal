package com.insidecoding.vassal.command;

import java.io.PrintWriter;

public class DisplayUsageAction extends VassalAction {

	@Override
	public String getCommandName() {
		return "HELP";
	}

	@Override
	public void doLogic(PrintWriter writer, String... params) throws Exception {
		for (Commands item : Commands.values()) {
			writer.println(String.format("%-10s", item.command().toUpperCase())
					+ item.usage());
		}
	}

}
