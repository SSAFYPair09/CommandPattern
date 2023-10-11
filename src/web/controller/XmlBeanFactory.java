package web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlBeanFactory {
    private static XmlBeanFactory instance;
    private HashMap<String, Controller> beans = new HashMap<>();

    private XmlBeanFactory(String path) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(path, new MyDefaultHandler());
    }

    public static XmlBeanFactory getInstance(String path) throws Exception {
        if (instance == null) {
            instance = new XmlBeanFactory(path);
        }
        return instance;
    }

    public HashMap<String, Controller> getBeans() {
        return beans;
    }

    class MyDefaultHandler extends DefaultHandler {
        String id = null;
        String className = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if ("bean".equals(qName)) { // NPE 방지
                id = attributes.getValue("id");
                className = attributes.getValue("class");

            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("bean".equals(qName)) { // NPE 방지
                try {
                    Class c = Class.forName(className);
                    Controller obj = (Controller) c.getConstructor().newInstance(); // Java Reflection
                    beans.put(id, obj);
                    System.out.println(beans);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
