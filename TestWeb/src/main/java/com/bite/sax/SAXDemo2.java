package com.bite.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * 需求:将contact.xml文件使用SAX解析将
 * 1)创建解析器
 * 2)读取contact.xml文件
 *
 * 3)定义一个基于事件的处理程序(一个类 extends DefaultHandler)
 *      使用字符串缓存区对象StringBuffer
 *      定义一个方法---->可以将字符串缓存区的内容--->String类型
 *      public String getContent(){StringBuffer.toString()}
 * 开始标签startElement(String qName ,Atrributes attributes)
 *      sb.append(“<”+qName) ;   //<concat id=”001”>
 *      遍历属性列表
 *         getValue()/getName()
 *
 *    sb.append(属性名称=value)
 *
 * 文本内容
 *     String(ch,start,length) ;
 *
 * 结束标签
 *    Sb.append(“</”+qName+”>”);
 */
public class SAXDemo2 {
    public static void main(String[] args)throws Exception {
        //1)创建SAX解析器对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser() ;

        //创建事件处理程序对象
        MyDefaultHandler2 handler2 = new MyDefaultHandler2() ;
        //2)解析contact.xml文件
        parser.parse(SAXDemo2.class.getClassLoader().getResourceAsStream("contact.xml"),handler2);

       //将字符串缓冲区的内容打印出来--->转成字符串String
        String content = handler2.getContent();
        System.out.println(content);
    }
}
