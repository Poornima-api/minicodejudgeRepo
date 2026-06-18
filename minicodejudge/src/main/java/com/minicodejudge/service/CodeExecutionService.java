package com.minicodejudge.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;
@Service
public class CodeExecutionService {
	public String executeJavaCode(String sourceCode) {
		try {
			File folder = new File("temp");
			folder.mkdir();
			File javaFile = new File(folder, "Main.java");
			FileWriter writer = new FileWriter(javaFile);
			writer.write(sourceCode);
			writer.close();
			Process compileProcess = Runtime.getRuntime().exec("javac " + javaFile.getAbsolutePath());
			compileProcess.waitFor();
			BufferedReader compileError = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
			StringBuilder errors = new StringBuilder();
			String line;
			while ((line = compileError.readLine()) != null) {
				errors.append(line).append("\n");
			}
			if (!errors.isEmpty()) {
				return "compilation error\n" + errors;
			}
			Process runProcess = Runtime.getRuntime().exec("java -cp temp Main");
			runProcess.waitFor();
			BufferedReader outputReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
			StringBuilder output = new StringBuilder();
			while ((line = outputReader.readLine()) != null) {
				output.append(line).append("\n");
			}
			return output.toString();

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
