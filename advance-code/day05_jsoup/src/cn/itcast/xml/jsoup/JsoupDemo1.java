package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/*
* jsoup快速入门
* */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //1.导包并add as library
        //2.获取Document对象,根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树-->document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1获取第一个name的Element对象
        Element element = elements.get(0);

        /*System.out.println(element);
        System.out.println("========="); //区别下面两行*/
        //3.2获取数据4
        String name=element.text();
        System.out.println(name);

    }
}
