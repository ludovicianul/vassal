package com.insidecoding.vassal.command;

import java.io.OutputStream;
import java.io.PrintWriter;

public abstract class VassalNonInteractiveAction extends VassalAction {

	@Override
	protected void doLogic(OutputStream out, PrintWriter writer,
			String... params) {
		try {
			this.doLogic(out, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public abstract void doLogic(OutputStream out, String... params)
			throws Exception;
}
