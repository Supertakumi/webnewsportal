package experiments.code.listing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;

import java.util.Properties;
public class PropertiesFileBuilder {

	/**
	 * This class creates a .properties file with given key=value
	 * @throws IOException 
	 */
	private static Properties properties;
	private static String newsCategory = "category.newsportlet.newsportlet";
	private static String newsTitle = "javax.portlet.title";
	private static String newsUrl = "newsSource";
	

	
	public static void main(String[] args) throws IOException {
		/*properties = new Properties();
		properties.put(newsCategory, "News Portlet");
		properties.put(newsTitle,"Breaking News");
		properties.put(newsUrl, "F:/Eclipse/Workspace/Experiments/cricinfoIndia.xml");
		FileOutputStream fileout = new FileOutputStream(new File("Language-ext.properties"));
		properties.store(fileout, "Language-extension");*/
		
		Properties loadProperties = new Properties();
		loadProperties.load(new FileInputStream(new File("F:/Eclipse/Workspace/Experiments","WEB-INF/Language-ext.properties")));
		String url = (String) loadProperties.getProperty("newsSource");
		System.out.println("URL is: " + url);
	}

}
