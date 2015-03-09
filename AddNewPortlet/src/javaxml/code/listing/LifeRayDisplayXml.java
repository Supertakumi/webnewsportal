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
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class LifeRayDisplayXml {
  private static String configFile = "liferay-display.xml";

  public static void main (String args[]) throws Exception {
	  Properties properties = new Properties();
	  String baseDir = "E:/Project/Eclipse/Workspace/Experiments";
	  properties.load(new FileInputStream (new File(baseDir, "WEB-INF/Language-ext.properties")));
	  String portletId = properties.getProperty("javax.portlet.title");
	  portletId = portletId.replace(" ", "");
		
	  
	  
	  
	// Create a XMLOutputFactory
    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
    // Create XMLEventWriter
    XMLEventWriter eventWriter = outputFactory
        .createXMLEventWriter(new FileOutputStream(new File(baseDir,"WEB-INF/" +configFile)),"UTF-8");
    //Mention doctype
    
    // Create a EventFactory
    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    
    XMLEvent doctype = eventFactory.createDTD("<!DOCTYPE display " +
                  "PUBLIC \"-//Liferay//DTD Display 6.0.0//EN\" " +
                  "\"http://www.liferay.com/dtd/liferay-display_6_0_0.dtd\">");
    
    XMLEvent newline = eventFactory.createDTD("\n");
    XMLEvent tab = eventFactory.createDTD("\t");
    XMLEvent dTab = eventFactory.createDTD("\t\t");
    // Create and write Start Tag
    StartDocument startDocument = eventFactory.createStartDocument();
    eventWriter.add(startDocument);
    eventWriter.add(newline);
    eventWriter.add(doctype);
    eventWriter.add(newline);
    // Create display open tag
    StartElement displayStartElement = eventFactory.createStartElement("",
        "", "display");
    eventWriter.add(displayStartElement);
    eventWriter.add(newline);
    eventWriter.add(tab);
    
    //Create category tag
    Attribute name = eventFactory.createAttribute("name", "category.newsportlet.newsportlet");
    List<Attribute> categoryAttributes = Arrays.asList(name);
    List<?> nsList = Arrays.asList();
    StartElement categoryStartElement = eventFactory.createStartElement("", "", "category",categoryAttributes.iterator(),nsList.iterator());
    eventWriter.add(categoryStartElement);
    eventWriter.add(newline);
    
    
    //Create portlet tag
    Attribute id = eventFactory.createAttribute("id", portletId);
    List<Attribute> portletAttributes = Arrays.asList(id);
    StartElement portletStartElement = eventFactory.createStartElement("","","portlet",portletAttributes.iterator(),nsList.iterator());
    eventWriter.add(dTab);
    eventWriter.add(portletStartElement);
    eventWriter.add(newline);
    
    eventWriter.add(dTab);
    eventWriter.add(eventFactory.createEndElement("", "", "portlet"));
    eventWriter.add(newline);
    eventWriter.add(tab);
    eventWriter.add(eventFactory.createEndElement("", "", "category"));
    eventWriter.add(newline);
    eventWriter.add(eventFactory.createEndElement("", "", "display"));
    eventWriter.add(eventFactory.createEndDocument());
    eventWriter.close();
  }

} 
