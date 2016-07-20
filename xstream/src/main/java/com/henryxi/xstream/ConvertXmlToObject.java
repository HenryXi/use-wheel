package com.henryxi.xstream;

import com.thoughtworks.xstream.XStream;

public class ConvertXmlToObject {
    public static void main(String[] args) {
        String xml = "<user>\n" +
                "  <name>henry</name>\n" +
                "  <age>27</age>\n" +
                "  <addresses>\n" +
                "    <address>\n" +
                "      <country>China</country>\n" +
                "      <city>Hebei</city>\n" +
                "    </address>\n" +
                "    <address>\n" +
                "      <country>China</country>\n" +
                "      <city>Beijing</city>\n" +
                "    </address>\n" +
                "  </addresses>\n" +
                "</user>";

        XStream xStream = new XStream();
        xStream.processAnnotations(User.class);

        User henry = (User)xStream.fromXML(xml);
        System.out.println(henry.toString());
    }
}
