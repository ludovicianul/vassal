package com.insidecoding.vassal.command;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;

/**
 * Does a browser refresh.
 * 
 * @author milie
 *
 */
public class RefreshAction extends VassalAction {

	@Override
	public void doLogic(PrintWriter writer, String... params) throws Exception {
		Robot robot = new Robot();
		robot.mouseMove(400, 400);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);

	}

	@Override
	public String getCommandName() {
		return "REFRESH";
	}

}
