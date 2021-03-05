package toolbox;

public class Session {
	
	private int id;
	private String sessionName;
	
	public Session() {
		
		id = 0;
		
	}

	public Session(int id, String sessionName) {
		this.id = id;
		this.sessionName = sessionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", sessionName=" + sessionName + "]";
	}
	
}
