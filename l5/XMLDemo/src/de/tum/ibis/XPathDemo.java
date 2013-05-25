package de.tum.ibis;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathDemo {
	public static void main(String[] args) {
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true); // never forget this!
		DocumentBuilder builder;
		Document doc = null;
		try {
			builder = domFactory.newDocumentBuilder();

			InputStream in = XPathDemo.class
					.getResourceAsStream("./premiumCustomers.xml");

			doc = builder.parse(in);
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
			System.exit(1);
		} catch (SAXException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			System.out.println("Select all Kunden nodes");
			XPathExpression expr;
			expr = xpath.compile("/Kunden/Kunde");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			System.out.println("Select all Nodes with a PLZ of 48234");
			expr = xpath.compile("/Kunden/Kunde/Anschrift/PLZ[.=48234]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			System.out.println("Select first node which sex is not M");
			expr = xpath.compile("/Kunden/Kunde[@geschlecht!='M'][1]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			System.out.println("Select all customers which are born in 1972");
			expr = xpath.compile("//Kunde[@geburtsjahr=1972]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			System.out.println("Selects all customers");
			expr = xpath.compile("//Kunde[@geburtsjahr=1972]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			System.out
					.println("Select all customers which Nachname is Schmidt");
			expr = xpath.compile("/Kunden/Kunde[@nachname='Schmidt']/@vorname");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName() + " "
						+ nodes.item(i).getNodeValue());
			}

			System.out
					.println("Select all cusomters which only Hobby is Konzert");
			expr = xpath.compile("/Kunden/Kunde/Hobbies[.='Konzert']");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName() + " "
						+ nodes.item(i).getNodeValue());
			}

			System.out
					.println("Select Wohnort of all customers which are born befoer 1970");
			// expr = xpath
			// .compile("/Kunden/Kunde/Anschrift/Ort[../../@geburtsjahr < 1970]");
			// Alternative (mouch simpler solution is)
			expr = xpath
					.compile("/Kunden/Kunde[@geburtsjahr < 1970]/Anschrift/Ort");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName() + " "
						+ nodes.item(i).getTextContent());
			}

			System.out
					.println("Select Kundennummer of all customers which are playing Golf");
			expr = xpath
					.compile("/Kunden/Kunde/KundenNr[../Hobbies[contains(., 'Golf')]]");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName() + " "
						+ nodes.item(i).getTextContent());
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
