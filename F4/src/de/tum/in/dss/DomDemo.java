package de.tum.in.dss;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomDemo {

	private int nextNode(NodeList list, int index) {
		for (int i = index + 1; i < list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE)
				return i;
		}

		return -1;
	}

	public DomDemo() throws DOMException, ParseException {
		// Create InputSource
		InputStreamReader reader = new InputStreamReader(
				DomDemo.class.getResourceAsStream("/etc/employees.xml"));
		InputSource source = new InputSource(reader);

		try {
			// DocumentBuilder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Parse XML (returns Document)
			Document doc = builder.parse(source);

			Set<User> users = new HashSet<User>();

			NodeList list = doc.getChildNodes();
			Node root = list.item(0);
			if (root.getNodeName().equals("corporation")) {
				for (int i = 0; i < root.getChildNodes().getLength(); i++) {
					Node user = root.getChildNodes().item(i);
					if (user.getNodeName().equals("user")) {
						System.out.println("user");

						User userObject = new User();
						users.add(userObject);

						int id = Integer.parseInt(user.getAttributes().getNamedItem("identifier")
								.getTextContent());
						userObject.setId(id);

						NodeList userNodes = user.getChildNodes();
						int node = nextNode(userNodes, 0);
						Node nodeSurname = userNodes.item(node);
						userObject.setSurname(nodeSurname.getFirstChild().getNodeValue());

						node = nextNode(userNodes, node);
						Node nodeLastname = userNodes.item(node);
						userObject.setLastname(nodeLastname.getFirstChild().getNodeValue());

						node = nextNode(userNodes, node);
						Node nodeAge = userNodes.item(node);
						userObject.setAge(Integer.parseInt(nodeAge.getFirstChild().getNodeValue()));

						node = nextNode(userNodes, node);
						Node nodeBirth = userNodes.item(node);
						SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
						userObject.setBirth(format.parse(nodeBirth.getFirstChild().getNodeValue()));

						while ((node = nextNode(userNodes, node)) >= 0) {
							System.out.println("address");

							Address addressObject = new Address();
							NodeList addressNodes = userNodes.item(node).getChildNodes();

							int anode = nextNode(addressNodes, 0);
							Node cityNode = addressNodes.item(anode);
							addressObject.setCity(cityNode.getFirstChild().getTextContent());

							anode = nextNode(addressNodes, anode);
							Node plzNode = addressNodes.item(anode);
							addressObject.setPlz(plzNode.getFirstChild().getTextContent());

							anode = nextNode(addressNodes, anode);
							Node streetNode = addressNodes.item(anode);
							addressObject.setStreet(streetNode.getFirstChild().getTextContent());

							anode = nextNode(addressNodes, anode);
							Node housenumberNode = addressNodes.item(anode);
							addressObject.setHouseNumber(housenumberNode.getFirstChild()
									.getTextContent());
						}

					} else {
						// error
					}
				}
			} else {
				// error
			}

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public static void main(String arg[]) {
		try {
			new DomDemo();
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
