package main;

import editor.Editor;

/**
 * 
 * Main class
 * @author TerabyteTB
 *
 */
public class LauncherTest {

	public static void main(String[] args) { 
		
		Thread thread = new Thread(Editor::new);
		
		thread.start();

	}

}
