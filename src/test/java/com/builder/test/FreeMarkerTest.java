package com.builder.test;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.io.Writer;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import freemarker.template.Configuration;  
import freemarker.template.DefaultObjectWrapper;  
import freemarker.template.Template;  
  
public class FreeMarkerTest {  
    public static void main(String[] args) throws Exception {  
        Configuration config = new Configuration();  
        try {  
            config.setDirectoryForTemplateLoading(new File(""));  
            config.setObjectWrapper(new DefaultObjectWrapper());  
            //拿到test.ftl的模板(相当于html模板)  
            Template template = config.getTemplate("template\\test.ftl", "UTF-8");  
            // 创建数据模型  
            Map root = new HashMap();  
           
            Map product = new HashMap();  //方式二：单独映射键对。映射product  
            root.put("lastProduct", product); 
            
            
            product.put("url", "http://www.google.com");  
            product.put("name", "green hose");  
              
            Map nb=new HashMap();  
            nb.put("name", "标");  
            nb.put("add", "中昱达");  
            root.put("mm",nb);  
              
            //新建一个文件。  
            File file = new File("e://test.html");  
            if (!file.exists()) {//不存在文件则创建该文件。  
                // System.out.println("file exist");  
                file.createNewFile();  
            }  
            //创建该文件的输出字符流。  
            Writer out = new BufferedWriter(new FileWriter(file));  
            template.process(root, out);  
            out.flush();
            System.out.println("end###");
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
    }