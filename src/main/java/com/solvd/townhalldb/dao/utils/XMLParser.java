package com.solvd.townhalldb.dao.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLParser {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/resources/parsers/dbSchema.xml");
            NodeList propertiesList = doc.getElementsByTagName("Property");
            for(int i=0; i<propertiesList.getLength();i++){
                Node p = propertiesList.item(i);
                if(p.getNodeType() == Node.ELEMENT_NODE){
                    Element property = (Element) p;
                    String id = property.getAttribute("id");
                    NodeList nameList = property.getChildNodes();
                    for(int j=0;j< nameList.getLength(); j++){
                        Node n = nameList.item(j);
                        if(n.getNodeType() == Node.ELEMENT_NODE){
                            Element name = (Element) n;
                            System.out.println("Property "+id+ ": "+ name.getTagName() +
                                    " = "+ name.getTextContent());
                        }
                    }
                }
            }



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
