package com.insidecoding.vassal.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Runs a command on the computer the vassa is running.
 * 
 * @author milie
 *
 */
public class RunCmdAction extends VassalAction {

	@Override
	public void doLogic(PrintWriter writer, String... params) throws Exception {
		writer.println(getProcessOutput(params));
	}

	public static String getProcessOutput(String... command)
			throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder(command);

		processBuilder.redirectErrorStream(true);

		System.out.println("Start executing process");
		Process process = processBuilder.start();
		StringBuilder processOutput = new StringBuilder();

		try (BufferedReader processOutputReader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));) {
			String readLine;

			while ((readLine = processOutputReader.readLine()) != null) {
				processOutput.append(readLine + System.lineSeparator());
			}

			process.waitFor();
		}

		System.out.println("Finished executing process");
		return processOutput.toString().trim();
	}

	@Override
	public String getCommandName() {
		return "CMD";
	}

}
