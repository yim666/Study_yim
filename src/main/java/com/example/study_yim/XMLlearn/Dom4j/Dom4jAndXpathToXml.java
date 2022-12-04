package com.example.study_yim.XMLlearn.Dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

//Dom4J结合Xpath
public class Dom4jAndXpathToXml {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(Dom4jAndXpathToXml.class.getResource("/XMLlearn/Dom4j/users.xml"));

            System.out.println("1...使用绝对路径获取元素");
            //当前类方法的实现需导包jaxen
            Element element = (Element)document.selectSingleNode("/users/user/name");
            System.out.println(element.getText());

            System.out.println("2...使用相对路径获取元素");
            // ./当前目录  ，，/上一级目录
            Element node = (Element) element.selectSingleNode("../salary");
            System.out.println(node.getText());

            System.out.println("3...使用全文搜索获取元素");
            List<Node> nodes = document.selectNodes("//name");
            for (Node n:nodes){
                Element nameE = (Element) n;
                System.out.println(nameE.getText());
            }

            System.out.println("4...使用谓语（条件筛选）获取元素");
            Element element1 = (Element) document.selectSingleNode("//user[@id='YH1']");
            for (Node n:element1.elements()){
                Element element2 = (Element) n;
                System.out.println(element2.getName());
                System.out.println(element2.getText());
            }

        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
}
