package cn.itcast.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupXPath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupXPath.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据document对象创建JXDocument对象
        JXDocument jxDocument=new JXDocument(document);
        List<JXNode> jxNodes = jxDocument.selN("//student");
        System.out.println(jxNodes);//可直接打印List集合也可循环遍历
        System.out.println("===============");
        /*for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }*/
        //查询student标签下带有id属性的name标签，并且id属性值为itcast
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name[@id='itcast']");
        for(JXNode jxNode:jxNodes1){
            System.out.println(jxNode);
        }


    }
}
