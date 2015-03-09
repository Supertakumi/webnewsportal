package javaxml.code.listing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
public class WebXml {
	private static String configFile = "web.xml";
	
	public static void main(String[] args) throws Exception{

		Properties properties = new Properties();
		String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
		properties.load(new FileInputStream (new File(baseDir, "WEB-INF/Language-ext.properties")));
		String displayName = properties.getProperty("javax.portlet.title");		
		
		
		//Create a XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	    // Create XMLEventWriter
	    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(new File(baseDir,"WEB-INF/" +configFile)),"UTF-8");
	    //Mention doctype
	    
	    // Create a EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    XMLEvent newline = eventFactory.createDTD("\n");
	    XMLEvent tab = eventFactory.createDTD("\t");
	    //XMLEvent dTab = eventFactory.createDTD("\t\t");
	    
	    StartDocument startDocument = eventFactory.createStartDocument();
	    eventWriter.add(startDocument);
	    eventWriter.add(newline);
	    
	    Attribute xmlns = eventFactory.createAttribute("xmlns", "http://java.sun.com/xml/ns/j2ee ");
	    Attribute xmlnsXsi = eventFactory.createAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	    Attribute version = eventFactory.createAttribute("version","2.5");
	    Attribute xsiSchemaLocation = eventFactory.createAttribute("xsi:schemaLocation","http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_5.xsd");
	    List<Attribute> webAppAttributes = Arrays.asList(xmlnsXsi,xmlns,xsiSchemaLocation,version);
	    List<?> nsList = Arrays.asList(); 
	    StartElement webAppStartElement = eventFactory.createStartElement("","","web-app",webAppAttributes.iterator(),nsList.iterator());
	    eventWriter.add(webAppStartElement);
	    eventWriter.add(newline);
	    eventWriter.add(tab);
	    
	    StartElement displayNameStartElement = eventFactory.createStartElement("", "", "display-name");
	    eventWriter.add(displayNameStartElement);
	    Characters displayNameChars = eventFactory.createCharacters(displayName);
        eventWriter.add(displayNameChars);
	    eventWriter.add(eventFactory.createEndElement("", "", "display-name"));
	    eventWriter.add(newline);
	    
	    eventWriter.add(eventFactory.createEndElement("","","web-app"));
	    
	    
	    
	}

}
