package com.insidecoding.vassal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.insidecoding.vassal.command.Commands;
import com.insidecoding.vassal.command.VassalAction;

/**
 * This is an actual thread that will handle the incoming commands from
 * different clients.
 * 
 * @author milie
 * 
 */
public class Vassal implements Runnable {
	private Socket skt;

	public Vassal(Socket srv) {
		this.skt = srv;
	}

	public void run() {
		System.out.println("New Client connected!");
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				skt.getInputStream()));
				PrintWriter pw = new PrintWriter(skt.getOutputStream(), true);) {
			pw.println("Yes, Master: ");

			while (true) {
				String commands[] = br.readLine().split(" ");

				if (commands.length > 0) {
					pw.println("Doing: " + commands[0]);
					VassalAction action = Commands.getAction(commands[0]);
					if ("quit".equalsIgnoreCase(commands[0])) {
						pw.close();
						br.close();
						break;
					} else if (action != null) {
						System.out.println("Doing: " + action);
						action.execute(pw, commands);
					} else {
						pw.println(commands[0] + " not supported");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
