package toolbox;

import java.util.logging.Logger;

/**
 * 
 * Constants class
 * @author TerabyteTB
 * @version 1.0
 *
 */
public final class Constants {
	
	private Constants() {}
	
	/**
	 * Logger for all classes (in case i ever need it)
	 */
	public static final Logger LOGGER = Logger.getGlobal();
	
	public static final String DIR = SessionHandler.getOSName().startsWith("Windows") ? "C:\\Apps\\SimpleJ2\\" : SessionHandler.getOSName().startsWith("Linux") ? "/home/" + System.getProperty("user.name") + "whirlpooleditor/" : "";

}
