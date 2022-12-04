package com.example.study_yim.XMLlearn.Dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

public class Dom4jToXml {
    public static void main(String[] args) {
        //创建解析器对象
        SAXReader saxReader = new SAXReader();
        try {
            //把xml转换为Document对象
            URL resource = Dom4jToXml.class.getResource("/XMLlearn/Dom4j/users.xml");
            System.out.println(resource);
            Document document = saxReader.read(resource);

            Element rootElement = document.getRootElement();
            System.out.println("xml根节点名字"+rootElement.getName());

            System.out.println("根标签下的子标签列表如下：");
            List<Element> elements = rootElement.elements();
            for(Element e:elements){
                System.out.println("根标签下的子标签之一："+e.getName());
                System.out.println("获取标签的属性："+e.attributeValue("id"));

                System.out.println("获取当前标签下的子标签");
                List<Element> subEs = e.elements();
                for(Element subE:subEs){
                    System.out.println("子标签名字"+subE.getName());
                    System.out.println("子标签文本<> 文本</> : "+subE.getText());
                }
            }

            //获取第一个user标签(但是必须是根标签的次一级标签)
            Element firstUser = rootElement.element("user");
            System.out.println("获取第一个user标签 ： "+firstUser.element("name").getText());
            System.out.println("获取第一个user标签(作用同上：)"+firstUser.elementText("name"));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
