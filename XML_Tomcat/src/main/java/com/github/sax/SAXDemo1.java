package com.github.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.创建一个SAX解析器对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

        // 2.读取xml文件,事件源：contact.xml
        parser.parse(SAXDemo1.class.getClassLoader().getResourceAsStream("contact.xml"),new MyDefaultHandler1());


    }
}
