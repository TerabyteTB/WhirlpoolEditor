package toolbox;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class SessionHandler {
	
	private SessionHandler() {}
	
	public static void startSession() throws IOException {
		
		int id = 0;
		ObjectMapper mapper = new ObjectMapper();
		Session session = new Session();
		String dir = "C:\\Apps\\JSimple\\";
		File sessionDir = new File(dir);
		sessionDir.mkdirs();
		File sessionFile = new File(dir + "session.ssn");
		sessionFile.createNewFile();
		
		JSONFormatter.formatAndPrintJSON("C:\\Apps\\SimpleJ2\\", "session.ssn", session);
		
	}

}
