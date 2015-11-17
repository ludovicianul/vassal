package com.insidecoding.vassal.command;


public enum Commands {
	REFRESH("refresh", new RefreshAction()), START_URL("url",
			new StartUrlAction()), RUN_CMD("cmd", new RunCmdAction()), KEYS(
			"key", new PressKeyAction()), TYPE("type", new TypeKeysAction());

	private String command;
	private PuppetAction action;

	Commands(String name, PuppetAction act) {
		this.command = name;
		this.action = act;
	}

	public static PuppetAction getAction(String command) {
		for (Commands comm : values()) {
			if (comm.command.toLowerCase().equalsIgnoreCase(
					command.toLowerCase())) {
				return comm.action;
			}
		}

		return null;
	}
}
