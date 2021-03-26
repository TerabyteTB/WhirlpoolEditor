package utils;

import java.io.File;
import java.util.logging.Logger;

import utils.session.SessionHandler;

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
	
	/**
	 * Editor session path
	 */
	public static final String DIR = new File("C:\\").exists() ? "C:\\Apps\\SimpleJ2\\" : new File("/home/").exists() ? "/home/" + System.getProperty("user.name") + "whirlpooleditor/" : "";

}
