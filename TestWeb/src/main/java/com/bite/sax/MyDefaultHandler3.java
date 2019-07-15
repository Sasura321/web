package com.bite.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyDefaultHandler3 extends DefaultHandler {

    //创建一个List集合对象
    private List<Contact> list = new ArrayList<Contact>() ;
    //定义一个方法
    public List<Contact> getList(){
        return list ;
    }

    //声明一个Concat对象
    private Contact contact = null ;

    //定义变量,记录当前读取到的标签名称
    private String curTag;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
     curTag = qName ;
        //如何判断读到就是:concat标签
        if(qName.equals("contact")){
            //创建一个联系人对象
            contact = new Contact() ;

            //通过属性名称获取属性值
            String id = attributes.getValue("id");
            //封装id属性
            contact.setId(id);
        }
    }


    //触发文本的事件
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       //每次到的实际文本内容
        String content = new String(ch,start,length) ;
        //问题:如何判断读取到就是name,phone,email....
        //要判断curTag是name,还是phone....
        if("name".equals(curTag)){
            contact.setName(content);
        }

        if("gender".equals(curTag)){
            contact.setGender(content);
        }

        if("phone".equals(curTag)){
            contact.setPhone(content);
        }

        if("email".equals(curTag)){
            contact.setEmail(content);
        }
        if("address".equals(curTag)){
            contact.setAddress(content);
        }


    }

    //结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        //清空curTag:空格换行
        curTag =null ;
        //qName:结束标签名称
        if(qName.equals("contact")){
            list.add(contact) ;
        }
    }
}
