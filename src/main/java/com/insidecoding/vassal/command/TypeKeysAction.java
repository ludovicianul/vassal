package com.insidecoding.vassal.command;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;

/**
 * Types a given string on the machine the vassal is running.
 * 
 * @author milie
 *
 */
public class TypeKeysAction extends VassalAction {

	@Override
	public void doLogic(PrintWriter writer, String... params) throws Exception {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < params.length; i++) {
			builder.append(" ").append(params[i]);
		}
		type(builder.toString().trim());
	}

	private static void type(String characters) throws Exception {
		Robot robot = new Robot();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(characters);
		clipboard.setContents(stringSelection, new StringSelection(characters));

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	@Override
	public String getCommandName() {
		return "TYPE";
	}

}
