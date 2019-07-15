package com.bite.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 编写监听器:自定义类 继续自基类(DefaultHandler)
 */
public class MyDefaultHandler1 extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.startDocument:文档开始...");
    }

    /**
     *开始标签
     * @param qName
     *        开始标签名称 <contact id="" name="">
     * @param attributes
     *        属性列表
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler1.startElement:"+qName);
    }

    /**
     * 遇到文本内容
     * @param ch
     * @param start
     * @param length
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       //遇到文本:每次读取的是当前文本的实际内容
        //
        //                       张三
        String content =  new String(ch,start,length) ;
        System.out.println("MyDefaultHandler1.characters:"+content);
    }

    /**
     * 遇到文档结束
     * @param uri
     * @param localName
     * @param qName   结束标签名称
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("MyDefaultHandler1.endElement:"+qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.endDocument:文档解析结束了...");
    }
}
