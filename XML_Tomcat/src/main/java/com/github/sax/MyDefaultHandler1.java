package com.github.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 编写监听器：自定义类，继续自基类
 */

public class MyDefaultHandler1 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.startDomcument:文档开始...");
    }

    /**
     * 开始标签
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

    }

    /**
     * 遇到文本内容
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 遇到文本：每次读取的时当前文本的实际内容
        String content = new String(ch,start,length);
        System.out.println("MyDefaultHandler1.characters:"+content);
    }

    /**
     * 遇到文档结束
     */
    @Override
    public void endElement(String uri, String localNAme, String qName) throws SAXException {
        System.out.println("MyDefaultHandler1.endElement:" + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.endDocument:文档解析结束");
    }
}
