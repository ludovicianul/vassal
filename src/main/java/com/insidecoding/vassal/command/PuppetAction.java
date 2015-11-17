package com.insidecoding.vassal.command;

import java.io.PrintWriter;

public abstract class PuppetAction {

	public void execute(PrintWriter writer, String... params) {
		try {
			String[] toExecute = new String[params.length - 1];
			for (int i = 1; i < params.length; i++) {
				toExecute[i - 1] = params[i];
			}

			doLogic(writer, toExecute);
			writer.println(getCommandName() + " executed succesfully");
		} catch (Exception e) {
			writer.println("Error executing " + getCommandName() + " "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}

	public abstract String getCommandName();

	public abstract void doLogic(PrintWriter writer, String... params)
			throws Exception;

}
