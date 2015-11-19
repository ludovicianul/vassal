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
	private final ExecutorService executor = Executors.newCachedThreadPool();

	public Main(int port) {
		this.port = port;
	}

	/**
	 * Starts the Master of Puppets server
	 */
	public void start() {
		try (ServerSocket srvr = new ServerSocket(port);) {
			System.out.println("Server started");
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							// this will keep the remote machine on
							Robot robot = new Robot();
							int i = 100;
							robot.mouseMove(i++, i++);
							Thread.sleep(15000);
						} catch (Exception e) {
							e.printStackTrace();
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
		new Main(Integer.parseInt(args[0])).start();
	}
}
