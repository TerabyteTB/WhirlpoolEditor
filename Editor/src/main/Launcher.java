package main;

import java.io.IOException;

import editor.Editor;

/**
 * 
 * Main class
 * @author TerabyteTB
 *
 */
public class Launcher {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Thread thread = new Thread(() -> {
			try {
				Editor editor = new Editor();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		thread.start();

	}

}
