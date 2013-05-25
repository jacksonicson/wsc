package de.tum.ibis;

import java.io.StringReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class StaxDemo {

	public StaxDemo() throws XMLStreamException {
		// XML File
		String xmlFile = "<root>" + "<a/>" + "<a>BlaBla</a>" + "</root>";

		// Reader
		StringReader reader = new StringReader(xmlFile);

		// XmlStreamReader
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader parser = factory.createXMLStreamReader(reader);

		// Parser (Loop)
		while (parser.hasNext()) {
			switch (parser.getEventType()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Start Document");
				break;
			case XMLStreamConstants.START_ELEMENT:
				System.out.println("Start Element: " + parser.getName());
				break;
			case XMLStreamConstants.CDATA:
				System.out.println("CData: " + parser.getElementText());
				break;
			}

			// Next Event
			parser.next();
		}

		
		// ***********************************************
		
		// Create XMLStreamWriter
		XMLOutputFactory facOut = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = facOut.createXMLStreamWriter(System.out);

		// Document
		writer.writeStartDocument();
		
		// Start Element
		writer.writeStartElement("root");

		// Start Element
		writer.writeStartElement("a");
		writer.writeAttribute("id", "sdf");
		writer.writeEndElement();

		// Close Element
		writer.writeEndElement();
		writer.writeEndDocument();

		// Flush and Close
		writer.flush();
		writer.close();

	}

	public static void main(String arg[]) {
		try {
			new StaxDemo();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
