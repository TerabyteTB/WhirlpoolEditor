package toolbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Formats JSON
 * @author Yim
 * @version 1.0
 * @since 1.0
 *
 */
public final class JSONFormatter {
	
	private JSONFormatter() {}
	
	/**
	 * 
	 * @param <T> type of object that you want to convert to JSON
	 * @param path path of JSON file
	 * @param fileName name of the file
	 * @param jsonData object that you want to convert to JSON
	 */
	public static <T> void formatAndPrintJSON(String path, String fileName, T jsonData) {
		
		File fileDir = new File(path);
		fileDir.mkdirs();
		File file = new File(path + fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(json);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
