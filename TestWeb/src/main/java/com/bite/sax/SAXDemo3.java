package com.bite.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

/**
 * 使用SAX解析 解析contact.xml,遇到contact标签的时候,将Contact联系人对象
 *
 * 思路:
 *    1)可以构造一个List<Contact>
 *    2)遇到contact开始标签,创建一个联系人对象Contact,封装属性
 *    3)遇到结束标签,读完了之后,可以将Conact联系人对象添加List<Contact>
 *    4)遍历集合
 */
public class SAXDemo3 {
    public static void main(String[] args) throws Exception {
        //1)解析器对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser() ;
        MyDefaultHandler3 handler3 = new MyDefaultHandler3() ;
        //2)解析
        parser.parse(SAXDemo3.class.getClassLoader().getResourceAsStream("contact.xml"),handler3);

        List<Contact> list = handler3.getList() ;
        for(Contact contact :list){
            System.out.println(contact);
        }
    }
}
