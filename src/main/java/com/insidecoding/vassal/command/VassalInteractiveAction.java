package com.insidecoding.vassal.command;

import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class VassalInteractiveAction extends VassalAction {

	@Override
	protected void doLogic(OutputStream out, PrintWriter writer,
			String... params) {
		try {
			doLogic(writer, params);
			writer.println(getCommandName() + " executed succesfully!");
		} catch (Exception e) {
			writer.println("Error executing " + getCommandName() + " "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public abstract void doLogic(PrintWriter writer, String... params)
			throws Exception;
}
