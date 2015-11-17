package com.insidecoding.vassal.command;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.regex.Pattern;

/**
 * Presses a key or a 2 keys combination like: CTRL+V, CTRL+C, etc.
 * 
 * @author milie
 *
 */
public class PressKeyAction extends PuppetAction {

	@Override
	public void doLogic(PrintWriter writer, String... params) throws Exception {
		Robot robot = new Robot();
		for (int i = 0; i < params.length; i++) {
			if (params[i].indexOf("+") != -1) {
				String[] comp = params[i].split(Pattern.quote("+"));
				int keyMask = getKeyEvent(comp[0]);
				int keyEvent = getKeyEvent(comp[1]);
				robot.keyPress(keyMask);
				robot.keyPress(keyEvent);
				robot.keyRelease(keyEvent);
				robot.keyRelease(keyMask);
			} else {
				int keyEvent = getKeyEvent(params[i]);
				robot.keyPress(keyEvent);
				robot.keyRelease(keyEvent);
			}
		}
	}

	public int getKeyEvent(String source) throws Exception {
		String code = "VK_" + source.toUpperCase();
		Field f = KeyEvent.class.getField(code);
		return f.getInt(null);
	}

	public String getCommandName() {
		return "KEY";
	}
}
