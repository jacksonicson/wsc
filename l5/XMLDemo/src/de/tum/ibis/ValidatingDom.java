package de.tum.ibis;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ValidatingDom {

	public ValidatingDom() throws FileNotFoundException {
		// Create a new input source
		InputSource source = new InputSource(
				ValidatingDom.class.getResourceAsStream("/etc/test.xml"));

		try {
			// DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			// Set namespace awareness
			factory.setNamespaceAware(true);

			// Disable DTD validation
			factory.setValidating(false);

			// Create a new DOM tree builder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Schema factory
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");

			Schema schema = schemaFactory
					.newSchema(new Source[] { new StreamSource(
							ValidatingDom.class
									.getResourceAsStream("/etc/test.xsd")) });

			// Validate while parsing
			// factory.setSchema(schema);

			// Build a a new DOM tree by parsing an input source
			Document doc = builder.parse(source);

			// Validate DOM
			Validator validator = schema.newValidator();
			try {
				validator.validate(new DOMSource(doc));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Iterate over all nodes
			// First level
			NodeList list = doc.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				System.out.println("Node: " + node.getNodeName());

				// Next level
				for (int j = 0; j < node.getChildNodes().getLength(); j++) {
					Node childNode = node.getChildNodes().item(i);
					System.out
							.println("Child node: " + childNode.getNodeName());

					// Manipulate document: remove child nodes
					node.removeChild(childNode);
				}
			}

			// Manipulate document
			for (int i = 0; i < 10; i++) {
				Element element = doc.createElement("z");
				element.setAttribute("id", "" + i);
				doc.getChildNodes().item(0).appendChild(element);
			}

			// Validate DOM again - this will fail as modifications are invalid
			// try {
			// validator.validate(new DOMSource(doc));
			// } catch (Exception e) {
			// e.printStackTrace();
			// }

			// Transform DOM tree to XML again
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
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		try {
			new ValidatingDom();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
