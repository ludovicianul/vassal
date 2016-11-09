package com.insidecoding.vassal;

import java.awt.Robot;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class is actually a Telnet server. It accepts a limited number of
 * commands that allows you to interact with the smart board
 * 
 * @author milie
 * 
 */
public class Main {
	private int port;
	private static final ExecutorService executor = Executors.newCachedThreadPool();

	public Main(int port) {
		this.port = port;
	}

	/**
	 * Starts the Master of Puppets server
	 */
	public void start() {
		try (ServerSocket srvr = new ServerSocket(port);) {
			System.out.println("Server started");
			new Thread(() -> {
				while (true) {
					try {
						// this will keep the remote machine on
						Robot robot = new Robot();
						int i = 100;
						robot.mouseMove(i++, i++);
					} catch (Exception e) {
						// just ignore the exception if headless environment
					} finally {
						try {
							Thread.sleep(15000);
						} catch (InterruptedException e) {
							// ignore this also
						}
					}
				}

			}).start();

			while (true) {
				Socket skt = srvr.accept();
				executor.execute(new Vassal(skt));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String... args) {
		int port = 12345;
		if (args.length == 1) {
			port = Integer.parseInt(args[0]);
		}
		if (System.getProperty("DISPLAY") == null) {
			System.setProperty("DISPLAY", ":1");
		}
		new Main(port).start();
	}
}
