package com.rajvardhan.entities;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.rajvardhan.contracts.Loggerable;

@Primary
@Component
public class FileLogger implements Loggerable {
	private String path;

	public FileLogger() {
		this.path = "LogText.txt";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public void log(String message) {
		System.out.println("File: " + message);
		try (FileOutputStream fout = new FileOutputStream(this.path, true)) {
			try (PrintStream out = new PrintStream(fout)) {
				out.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void print(String msg) {
		System.out.println("File Logger ::" + msg);
	}

}
