package javaxml.code.listing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
//import java.util.Arrays;
//import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
//import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class LifeRayPortletXml {
	private static String configFile = "liferay-portlet.xml";
	
	public static void main(String[] args) throws Exception {
		
		Properties properties = new Properties();
		String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
		properties.load(new FileInputStream (new File(baseDir, "WEB-INF/Language-ext.properties")));
		String portletName = properties.getProperty("javax.portlet.title");
		portletName = portletName.replace(" ","");
		String cssClassWrapperName = portletName.toLowerCase();
		// Create a XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	    // Create XMLEventWriter
	    XMLEventWriter eventWriter = outputFactory
	        .createXMLEventWriter(new FileOutputStream(new File(baseDir,"WEB-INF/" +configFile)),"UTF-8");
	    //Mention doctype
	    
	    // Create a EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    
	    XMLEvent doctype = eventFactory.createDTD("<!DOCTYPE liferay-portlet-app " +
	                  "PUBLIC \"-//Liferay//DTD Portlet Application 6.0.0//EN\" " +
	                  "\"http://www.liferay.com/dtd/liferay-portlet-app_6_0_0.dtd\">");
	    
	    XMLEvent newline = eventFactory.createDTD("\n");
	    XMLEvent tab = eventFactory.createDTD("\t");
	    XMLEvent dTab = eventFactory.createDTD("\t\t");
	    
	    StartDocument startDocument = eventFactory.createStartDocument();
	    eventWriter.add(startDocument);
	    eventWriter.add(newline);
	    eventWriter.add(doctype);
	    eventWriter.add(newline);
	    
	    //Create root element liferay-portlet-app
	    StartElement liferayPortletAppStartElement = eventFactory.createStartElement("","", "liferay-portlet-app");
	        eventWriter.add(liferayPortletAppStartElement);
	        eventWriter.add(newline);
	        eventWriter.add(tab);
	        
	    //Create portlet element
	    StartElement portletStartElement = eventFactory.createStartElement("", "", "portlet");
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
	    
	    //Create instanceable element
        StartElement instanceableStartElement = eventFactory.createStartElement("", "", "instanceable");
	    eventWriter.add(instanceableStartElement);
	    Characters instanceableChars = eventFactory.createCharacters("false");
        eventWriter.add(instanceableChars);
        eventWriter.add(eventFactory.createEndElement("", "", "instanceable"));
        eventWriter.add(newline);
        eventWriter.add(dTab);
        
        //Create remoteable element
        StartElement remoteableStartElement = eventFactory.createStartElement("", "", "remoteable");
	    eventWriter.add(remoteableStartElement);
	    Characters remoteableChars = eventFactory.createCharacters("true");
        eventWriter.add(remoteableChars);
        eventWriter.add(eventFactory.createEndElement("", "", "remoteable"));
        eventWriter.add(newline);
        eventWriter.add(dTab);
                
        //Create css-class-wrapper element
        StartElement cssClassWrapperStartElement = eventFactory.createStartElement("","","css-class-wrapper");
        eventWriter.add(cssClassWrapperStartElement);
        Characters cssClassWrapperChars = eventFactory.createCharacters(cssClassWrapperName);
        eventWriter.add(cssClassWrapperChars);
        eventWriter.add(eventFactory.createEndElement("","","css-class-wrapper"));
        eventWriter.add(dTab);
        eventWriter.add(newline);
        
        
        eventWriter.add(tab);
        eventWriter.add(eventFactory.createEndElement("", "", "portlet"));
        eventWriter.add(newline);
        eventWriter.add(eventFactory.createEndElement("", "", "liferay-portlet-app"));
        
	}

}
