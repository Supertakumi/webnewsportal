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

public class PortletXml {
	private static String configFile = "portlet.xml";
	
	public static void main(String[] args) throws Exception{
		
		Properties properties = new Properties();
		String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
		properties.load(new FileInputStream (new File(baseDir, "WEB-INF/Language-ext.properties")));
		String displayName = properties.getProperty("javax.portlet.title");
		String portletName = displayName.replace(" ","");		
		
		// Create a XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	    // Create XMLEventWriter
	    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(new File(baseDir,"WEB-INF/" +configFile)),"UTF-8");
	    //Mention doctype
	    
	    // Create a EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    XMLEvent newline = eventFactory.createDTD("\n");
	    XMLEvent tab = eventFactory.createDTD("\t");
	    XMLEvent dTab = eventFactory.createDTD("\t\t");
	    
	    StartDocument startDocument = eventFactory.createStartDocument();
	    eventWriter.add(startDocument);
	    eventWriter.add(newline);
	    
	    //Create portlet-app element
	    Attribute xmlns = eventFactory.createAttribute("xmlns", "http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd ");
	    Attribute xmlnsXsi = eventFactory.createAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	    Attribute version = eventFactory.createAttribute("version","2.0");
	    Attribute xsiSchemaLocation = eventFactory.createAttribute("xsi:schemaLocation","http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd http://java.sun.com/xml/ns/portlet/portlet-app_2_0.xsd");
	    List<Attribute> portletAppAttributes = Arrays.asList(xmlnsXsi,xmlns,xsiSchemaLocation,version);
	    List<?> nsList = Arrays.asList(); 
	    StartElement portletAppStartElement = eventFactory.createStartElement("","","portlet-app",portletAppAttributes.iterator(),nsList.iterator());
	    eventWriter.add(portletAppStartElement);
	    eventWriter.add(newline);
	    eventWriter.add(tab);
	    
	    //Create portlet element
	    StartElement portletStartElement = eventFactory.createStartElement("","","portlet");
	    eventWriter.add(portletStartElement);
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    
	    //Create portlet-name element
	    StartElement portletNameStartElement = eventFactory.createStartElement("", "", "portlet-name");
	    eventWriter.add(portletNameStartElement);
	    Characters portletNameChars = eventFactory.createCharacters(portletName);
        eventWriter.add(portletNameChars);
	    eventWriter.add(eventFactory.createEndElement("", "", "portlet-name"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    
	    //Create display-name element
	    StartElement displayNameStartElement = eventFactory.createStartElement("", "", "display-name");
	    eventWriter.add(displayNameStartElement);
	    Characters displayNameChars = eventFactory.createCharacters(displayName);
        eventWriter.add(displayNameChars);
	    eventWriter.add(eventFactory.createEndElement("", "", "display-name"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    
	    //Create portlet-class element
	    StartElement portletClassStartElement = eventFactory.createStartElement("", "", "portlet-class");
	    eventWriter.add(portletClassStartElement);
	    Characters portletClassChars = eventFactory.createCharacters("experiments.code.listing.ReadFeedPortlet");
        eventWriter.add(portletClassChars);
	    eventWriter.add(eventFactory.createEndElement("", "", "portlet-class"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    
	    //Create supports element
	    StartElement supportsStartElement = eventFactory.createStartElement("", "", "supports");
	    eventWriter.add(supportsStartElement);
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    eventWriter.add(tab);
	    //Create mime-type element
	    StartElement mimeTypeStartElement = eventFactory.createStartElement("", "", "mime-type");
	    eventWriter.add(mimeTypeStartElement);
	    Characters mimeTypeChars = eventFactory.createCharacters("text/html");;
	    eventWriter.add(mimeTypeChars);
	    eventWriter.add(eventFactory.createEndElement("","","mime-type"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    eventWriter.add(tab);
	    //Create portlet-mode element
	    StartElement portletModeStartElement = eventFactory.createStartElement("", "", "portlet-mode");
	    eventWriter.add(portletModeStartElement);
	    Characters portletModeChars = eventFactory.createCharacters("view");;
	    eventWriter.add(portletModeChars);
	    eventWriter.add(eventFactory.createEndElement("","","portlet-mode"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);	    
	    eventWriter.add(eventFactory.createEndElement("","","supports"));
	    eventWriter.add(newline);
	    eventWriter.add(dTab);
	    
	    //Create resource-bundle element
	    StartElement resourceBundleStartElement = eventFactory.createStartElement("", "", "resource-bundle");
	    eventWriter.add(resourceBundleStartElement);
	    Characters resourceBundleChars = eventFactory.createCharacters("content.Language-ext");
	    eventWriter.add(resourceBundleChars);
	    eventWriter.add(eventFactory.createEndElement("","","resource-bundle"));
	    eventWriter.add(newline);
	    eventWriter.add(tab);
	    
	    eventWriter.add(eventFactory.createEndElement("","","portlet"));
	    eventWriter.add(newline);
	    eventWriter.add(eventFactory.createEndElement("","","portlet-app"));
	    
	    
	}

}
