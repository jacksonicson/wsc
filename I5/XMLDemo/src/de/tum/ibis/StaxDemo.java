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
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlReader = inputFactory.createXMLStreamReader(reader);

		// ***********************************************

		// Parser (Loop)
		while (xmlReader.hasNext()) {
			switch (xmlReader.getEventType()) {
			case XMLStreamConstants.START_DOCUMENT:
				System.out.println("Start Document");
				break;
			case XMLStreamConstants.START_ELEMENT:
				System.out.println("Start Element: " + xmlReader.getName());
				break;
			case XMLStreamConstants.CDATA:
				System.out.println("CData: " + xmlReader.getElementText());
				break;
			}

			// Next Event
			xmlReader.next();
		}

		// ***********************************************

		// Create XMLStreamWriter
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLStreamWriter xmlWriter = outputFactory
				.createXMLStreamWriter(System.out);

		// Document
		xmlWriter.writeStartDocument();

		// Start Element
		xmlWriter.writeStartElement("root");

		// Start Element
		xmlWriter.writeStartElement("a");
		xmlWriter.writeAttribute("id", "sdf");
		xmlWriter.writeEndElement();

		// Close Element
		xmlWriter.writeEndElement();
		xmlWriter.writeEndDocument();

		// Flush and Close
		xmlWriter.flush();
		xmlWriter.close();

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
