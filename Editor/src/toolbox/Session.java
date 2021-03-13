package toolbox;

public class Session {
	
	public static int id = 0;
	private int sessionID;
	private String sessionName;
	private String value;
	
	public Session() {
		
		sessionID = id;
		sessionName = "session" + id;
		id++;
		value = "none";
		
	}

	public Session(String value) {
		sessionID = id;
		sessionName = "session" + id;
		id++;
		this.value = value;
	}

	public Session(int sessionID, String sessionName, String value) {
		this.sessionID = sessionID;
		this.sessionName = sessionName;
		this.value = value;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		assert sessionID > id;
		this.sessionID = sessionID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionName=" + sessionName + ", value=" + value + "]";
	}
	
}
