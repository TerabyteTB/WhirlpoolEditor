package toolbox;

/**
 * 
 * Represents a session
 * @author Yim
 * @version 1.1
 * @since 1.0
 *
 */
public class Session {
	
	/**
	 * id
	 */
	public static int id = 0;
	private int sessionID;
	private String sessionName;
	private String value;
	
	/**
	 * Makes new session
	 */
	public Session() {
		
		sessionID = id;
		sessionName = "session" + id;
		id++;
		value = "none";
		
	}

	/**
	 * Makes session with value (a <i>lot</i> more useful)
	 * @param value value of session
	 */
	public Session(String value) {
		sessionID = id;
		sessionName = "session" + id;
		id++;
		this.value = value;
	}

	/**
	 * Makes session with all the params (not used, but hey)
	 * @param sessionID sessionid
	 * @param sessionName session name
	 * @param value value of new session
	 * @deprecated
	 */
	public Session(int sessionID, String sessionName, String value) {
		this.sessionID = sessionID;
		this.sessionName = sessionName;
		this.value = value;
	}
	
	/**
	 * returns name
	 * @return name
	 */
	public String getSessionName() {
		return sessionName;
	}
	
	/**
	 * sets name
	 * @param sessionName name
	 */
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	/**
	 * returns id
	 * @return id
	 */
	public int getSessionID() {
		return sessionID;
	}
	
	/**
	 * sets id
	 * @param sessionID id
	 */
	public void setSessionID(int sessionID) {
		assert sessionID > id;
		this.sessionID = sessionID;
	}

	/**
	 * returns value
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * sets value
	 * @param value value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * to string method
	 * @return to string of object
	 */
	@Override
	public String toString() {
		return "Session [sessionID=" + sessionID + ", sessionName=" + sessionName + ", value=" + value + "]";
	}
	
}
