package com.github.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyDefaultHandler3 extends DefaultHandler {

    /**
     *  创建一个List集合对象
     */
    private List<Contact> list = new ArrayList<Contact>();

    // 定义一个方法
    public List<Contact> getList() {
        return list;
    }

    // 声明一个Concat对象
    private Contact contact = null;

    // 定义变量，记录当前读到的标签名称

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        curTag = qName;
//        // 如何判断读到的就是：concat 标签
//        if (qName.equals("contact")) {
//            contact = new Contact();
//        }
//
//        String id = attributes.getValue("id");
//        contact.setId(id);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 问题：如何让判断读取到的就是name.phone,email...
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }


}
