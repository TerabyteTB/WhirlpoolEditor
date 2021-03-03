package main;

import editor.TextEdit;

public class Main implements Runnable{
	
	private Thread thread;
	
	public Main() {
		
		thread = new Thread(this);
		thread.start();
		
	}

	@Override
	public void run() {
		
		TextEdit editor = new TextEdit();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
