package com.builder.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
  
public class FreeMarkerGenUtil<T,M> {  
	
	FileUtil fileUtil = new FileUtil();
	/**
	 * @param map
	 * @param targetFilePath 生成文件的绝对路径
	 */
	public  void genCode(Map<T,M> map,String targetFilePath,String templateFilePath){
		 Configuration config = new Configuration();  
	        try {  
	        	String rootPath = new FileUtil().getCurrentPath("/");
	            config.setDirectoryForTemplateLoading(new File(rootPath));
	            config.setObjectWrapper(new DefaultObjectWrapper());  
	            //拿到test.ftl的模板(相当于html模板)  
	            Template template = config.getTemplate(templateFilePath, "UTF-8");  
	            //新建一个文件。  
	            File file = new File(targetFilePath);  
	            if (!file.exists()) {//不存在文件则创建该文件。  
	                // System.out.println("file exist");  
	                file.createNewFile();  
	            }  
	            //创建该文件的输出字符流。  
	            Writer out = new BufferedWriter(new FileWriter(file));  
				template.process(map, out);
	            out.flush();
	           // System.out.println("生成完成");
	        } catch (IOException e) {
	            e.printStackTrace();  
	        }  catch (TemplateException e) {
				e.printStackTrace();
			}  
	}
	
    public static void main(String[] args) throws Exception {  
        Configuration config = new Configuration();  
        try {  
            config.setDirectoryForTemplateLoading(new File(""));  
            config.setObjectWrapper(new DefaultObjectWrapper());  
            //拿到test.ftl的模板(相当于html模板)  
            Template template = config.getTemplate("template\\service.ftl", "UTF-8");  
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
            e.printStackTrace();  
        }  
    }  
   }