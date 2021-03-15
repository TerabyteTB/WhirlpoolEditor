package main;

import java.io.IOException;

import editor.TextEdit;

public class Launcher {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> {
			try {
				TextEdit editor = new TextEdit();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		thread.start();

	}

}
