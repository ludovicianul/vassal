package com.insidecoding.vassal.command;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ScreencaptureAction extends VassalNonInteractiveAction {

	@Override
	public String getCommandName() {
		return "SCREENSHOT";
	}

	@Override
	public void doLogic(OutputStream out, String... params) throws Exception {
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();) {
			ImageIO.write(image, "png", outputStream);
			ImageIO.write(image, "png", new File("pozamea.png"));
			byte[] imageBytes = outputStream.toByteArray();

			out.write(imageBytes);
		}
	}

}
