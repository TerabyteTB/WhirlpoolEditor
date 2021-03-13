package toolbox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class SessionHandler {
	
	private static String dir = "C:\\Apps\\SimpleJ2\\";
	
	private SessionHandler() {}
	
	public static Session newSession() {
		
		Session session = new Session();
		File sessionDir = new File(dir);
		sessionDir.mkdirs();
		File sessionFile = new File(dir + "session_" + session.getSessionID() +".ssn");
		try {
			sessionFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONFormatter.formatAndPrintJSON(dir, "session_" + session.getSessionID() +".ssn", session);
		
		return session;
		
	}
	
public static Session newSession(String value) {
		
		Session session = new Session(value);
		File sessionDir = new File(dir);
		sessionDir.mkdirs();
		File sessionFile = new File(dir + "session_" + session.getSessionID() +".ssn");
		try {
			sessionFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONFormatter.formatAndPrintJSON(dir, "session_" + session.getSessionID() +".ssn", session);
		
		return session;
		
	}
	
	public static String openExistingSession(int id) {
		
		ObjectMapper mapper = new ObjectMapper();
		String value = "none";
		File sessionFile = new File("session_" + id + ".ssn");
		
		try {
			Map<?, ?> map = mapper.readValue(new File(dir + sessionFile), Map.class);
			for(Map.Entry<?, ?> entry : map.entrySet()) {
				if(entry.getKey().equals("value")) {
					value = (String) entry.getValue();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;
		
	}
	
	public static void removeSession(Session session) {
		
		File sessionFile = new File(dir + "session_" + session.getSessionID() + ".ssn");
		Session.id = session.getSessionID();
		sessionFile.delete();
		
	}

}
