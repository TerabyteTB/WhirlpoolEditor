package main;

import java.io.IOException;

import editor.TextEdit;

public class Main{
	
	public Main() {
		run();
	}

	public void run() {
		try {
			TextEdit editor = new TextEdit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
