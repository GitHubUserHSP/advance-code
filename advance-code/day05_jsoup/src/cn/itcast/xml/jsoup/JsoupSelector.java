package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
选择器查询
*/
public class JsoupSelector {
    public static void main(String[] args) throws IOException {
        String path = JsoupSelector.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取student标签并且number属性值为heima_0001的age子标签
        Elements elements= document.select("student[number='heima_0001']>age");
        System.out.println(elements);
    }
}
