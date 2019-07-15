package com.bite.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//基于事件的处理程序
public class MyDefaultHandler2 extends DefaultHandler {
    //声明一个字符串缓冲区对象
    private StringBuffer sb = new StringBuffer() ;

    //定义一个成语方法
    public String getContent(){
        return sb.toString() ;
    }


    //遇到开始标签
    //qName:标签名称
    //attributes:属性列表
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //<contact id="001">
        //拼接开始标签
        sb.append("<"+qName) ;
        //遍历属性列表
        for(int i = 0 ; i<attributes.getLength();i++) {  //int getLength():获取属性列表的长度
                 //获取到每一个属性对象
            String attrName = attributes.getQName(i) ;
            String attrValue = attributes.getValue(i);
            sb.append(" "+attrName+"=\""+attrValue+"\"") ; //双引号需要转义:\" 代表"
        }

        sb.append(">") ;
    }

    //文本内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content =new String(ch,start,length) ;
        sb.append(content) ;
    }

    //结束标签
    //qName:结束标签名称
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("</"+qName+">") ;
    }
}
