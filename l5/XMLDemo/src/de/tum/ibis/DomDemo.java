package de.tum.ibis;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomDemo {

	public DomDemo() {
		// XML File
		String xmlFile = "<root><a/><b></b><a/></root>";

		// Create InputSource
		StringReader reader = new StringReader(xmlFile);
		InputSource source = new InputSource(reader);

		try {
			// DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse XML (returns Document)
			Document doc = builder.parse(source);

			// Use DOM - iterate over all nodes
			NodeList list = doc.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("Node: " + node.getNodeName());

				for (int j = 0; j < node.getChildNodes().getLength(); j++) {
					Node childNode = node.getChildNodes().item(i);
					System.out.println("Child node: " + childNode.getNodeName());
					
					// Rmove child nodes
					node.removeChild(childNode);
				}
			}

			// Manipulate Document
			for (int i = 0; i < 10; i++) {
				Element element = doc.createElement("z");
				element.setAttribute("id", "" + i);
				doc.getChildNodes().item(0).appendChild(element);
			}

			// Transform Document to XML
			TransformerFactory tfac = TransformerFactory.newInstance();
			Transformer transformer = tfac.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			transformer.transform(domSource, new StreamResult(System.out));

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		new DomDemo();
	}
}
