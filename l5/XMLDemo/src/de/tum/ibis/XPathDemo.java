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
		
		domFactory.setNamespaceAware(true);
		
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

		// Create a new XPath factory
		XPathFactory factory = XPathFactory.newInstance();

		// New XPath
		XPath xpath = factory.newXPath();
		try {
			// 1st
			System.out.println("Select all Kunden nodes: ");
			XPathExpression expr = xpath.compile("/Kunden/Kunde");
			NodeList nodes = (NodeList) expr.evaluate(doc,
					XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

			// 2nd
			System.out.println("Select all Nodes with a PLZ of 48234");
			expr = xpath.compile("/Kunden/Kunde/Anschrift/PLZ[.=48234]");
			nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeName());
			}

		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
