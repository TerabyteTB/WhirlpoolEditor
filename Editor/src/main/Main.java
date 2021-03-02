package main;

import java.io.IOException;

import toolbox.SessionHandler;

public class Main {

	public static void main(String[] args) {
		
		try {
			SessionHandler.startSession();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
