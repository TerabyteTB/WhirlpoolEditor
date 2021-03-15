package main;

import java.io.IOException;

import editor.TextEdit;

public class Main implements Runnable{
	
	private Thread thread;
	
	public Main() {
		thread = new Thread(this);
		thread.start();
	}

	@SuppressWarnings("unused")
	public void start() {
		try {
			TextEdit editor = new TextEdit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
