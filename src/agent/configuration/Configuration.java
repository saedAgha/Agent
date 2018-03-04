package agent.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Configuration implements IConfigurable {

	private File configFile;

	public Configuration() {
		configFile = new File("C:\\SEIM\\config.properties");
	}

	public String Get(String key) {
		Properties props = new Properties();
		String value = "";
		try (FileReader reader = new FileReader(configFile)) {
			// load the properties file:
			props.load(reader);
			value = props.getProperty(key);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}

	public void Set(String key, String value) {

		try {

			Properties props = new Properties();
			try (FileReader reader = new FileReader(configFile)) {
				// load the properties file:
				props.load(reader);
				props.setProperty(key, value);
				try (FileWriter writer = new FileWriter(configFile)) {
					synchronized (writer) {
						props.store(writer, "Configuration Settings");
					}
				}
			}
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}

}
