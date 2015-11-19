package com.insidecoding.vassal.command;

import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class VassalAction {

	public void execute(OutputStream out, PrintWriter writer, String... params) {
		String[] toExecute = new String[params.length - 1];
		for (int i = 1; i < params.length; i++) {
			toExecute[i - 1] = params[i];
		}
		doLogic(out, writer, toExecute);
	}

	public abstract String getCommandName();

	protected abstract void doLogic(OutputStream out, PrintWriter writer,
			String... params);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
