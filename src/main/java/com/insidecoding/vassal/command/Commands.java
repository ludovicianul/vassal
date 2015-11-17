package com.insidecoding.vassal.command;

public enum Commands {
	REFRESH("refresh", new RefreshAction(), "Will press F5. Usage: refresh"), START_URL(
			"url",
			new StartUrlAction(),
			"Will open the supplied URL using the default browser. You need to supply the full URL, including http.Usage: url http://google.com"), RUN_CMD(
			"cmd",
			new RunCmdAction(),
			"Will run a command. The output of the command will be visible to you. Usage: cmd java -version"), KEYS(
			"key", new PressKeyAction(),
			"Will press the supplied keys. Usage: key CONTROL+F5"), TYPE(
			"type", new TypeKeysAction(),
			"Will type the supplied string. Usage: type username"), HELP("?",
			new DisplayUsageAction(),
			"Will display the available commands. Usage: ?");

	private String usage;
	private String command;
	private VassalAction action;

	Commands(String name, VassalAction act, String usage) {
		this.command = name;
		this.action = act;
		this.usage = usage;
	}

	public static VassalAction getAction(String command) {
		for (Commands comm : values()) {
			if (comm.command.toLowerCase().equalsIgnoreCase(
					command.toLowerCase())) {
				return comm.action;
			}
		}

		return null;
	}

	public String command() {
		return this.command;
	}

	public String usage() {
		return this.usage;
	}
}
