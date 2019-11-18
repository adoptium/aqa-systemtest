package net.adoptopenjdk.stf;

import java.io.File;
import java.io.FileWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class SummaryGenerator {
	public static void main (String[] args) {
		try { 
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(args[0]));
			doc.getDocumentElement ().normalize ();
			NodeList listOfTestResults = doc.getElementsByTagName("TestResult");
			String testPath = ""; 
			String message = ""; 
			StringBuffer resultSummary = new StringBuffer(); 
	
			for(int s=0; s<listOfTestResults.getLength() ; s++) {
				Node aResult = listOfTestResults.item(s);
				if(aResult.getNodeType() == Node.ELEMENT_NODE) {
					Element aResultElement = (Element) aResult; 
					testPath = aResultElement.getAttribute("url"); 
					NodeList ns = aResultElement.getElementsByTagName("ResultProperties"); 
					if ( ns != null) {
						Node resultPropertiesNode = ns.item(0);
						if (resultPropertiesNode != null) {
							if(resultPropertiesNode.getNodeType() == Node.ELEMENT_NODE) {
								Element aResultPropertiesElement = (Element) resultPropertiesNode; 
								NodeList properties = aResultPropertiesElement.getElementsByTagName("Property"); 
								for (int  i = 0 ; i < properties.getLength(); i++) {
									Node aProperty = properties.item(i); 
									if(aProperty.getNodeType() == Node.ELEMENT_NODE) {
										Element aPropertyElement = (Element) aProperty; 
										String name = aPropertyElement.getAttribute("name"); 
										if ( name != null && name.equals("execStatus")) {
											message = aPropertyElement.getAttribute("value"); 
											resultSummary.append(testPath + "   " + message + "\n");
											break; 
										}
									}
								}
							}
						}
					}
				}
			}
			FileWriter fw = new FileWriter(new File("summary.txt")); 
			fw.write(resultSummary.toString());
			fw.close();
			System.out.println(resultSummary.toString());
		} catch (SAXParseException err) {
			System.out.println ("Error processing XML JCK output report" + err.getMessage ());
			err.printStackTrace();
		}catch (SAXException e) {
			System.out.println ("Error processing XML JCK output report" + e.getMessage ());
			e.printStackTrace();
		}catch (Throwable t) {
			t.printStackTrace ();
		}
	}
}
