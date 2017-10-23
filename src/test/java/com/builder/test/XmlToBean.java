package com.builder.test;

import com.builder.bean.GeneratorConfiguration;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by why on 2016/6/30.
 */
public class XmlToBean {

    public static void main(String[] args) {
        XStream xStream = new XStream(new DomDriver());
        try {
            GeneratorConfiguration o = (GeneratorConfiguration) xStream.fromXML(new FileInputStream(new File("/E:/Intellij/code-builder/target/classes/generatorConfig.xml")));
            System.out.println(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
