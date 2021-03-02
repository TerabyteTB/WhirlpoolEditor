package toolbox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public final class JSONFormatter {
	
	public static void formatJSON(String fileName, String extension) {
		
		File file = new File(fileName + "." + extension);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			ObjectMapper mapper = new ObjectMapper();
			ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
			String json = reader.readLine();
			String formattedJSON = writer.writeValueAsString(json);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
