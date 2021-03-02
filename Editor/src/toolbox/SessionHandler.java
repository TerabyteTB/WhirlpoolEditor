package toolbox;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

public final class SessionHandler {
	
	private SessionHandler() {}
	
	@SuppressWarnings("unchecked")
	public static void startSession() throws IOException {
		
		int id = 0;
		JSONObject jsonObj = new JSONObject();
		File sessionDir = new File("C:\\Apps\\JSimple\\");
		sessionDir.mkdirs();
		File sessionFile = new File("C:\\Apps\\JSimple\\session.ssn");
		jsonObj.put("sessionName", "session" + id);
		jsonObj.put("sessionID", id);
		
		sessionFile.createNewFile();
		PrintWriter writer = new PrintWriter("C:\\Apps\\JSimple\\session.ssn");
		writer.write(jsonObj.toJSONString());
		writer.flush();
		writer.close();
		
	}

}
