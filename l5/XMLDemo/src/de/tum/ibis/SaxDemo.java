package de.tum.ibis;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxDemo {

	// Callback handler
	class MyHandler extends DefaultHandler {

		@Override
		public void startDocument() throws SAXException {
			System.out.println("Start Document");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("End Document");
		}

		@Override
		public void startPrefixMapping(String prefix, String uri)
				throws SAXException {
			System.out.println("Start Prefix Mapping");
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			System.out.println("Start Element: " + qName);
		}

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			System.out.println("Characters: " + new String(ch, start, length));
		}
	}

	public SaxDemo() {
		// XML File
		String xmlFile = "<root> " + "<a/>" + "<a>blabla test123</a>"
				+ "</root>";

		// Create a new input source 
		StringReader reader = new StringReader(xmlFile);
		InputSource source = new InputSource(reader);

		try {
			// SAX Parser
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

			// Parse XML File with an ew event handler
			parser.parse(source, new MyHandler());
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		new SaxDemo();
	}
}
