package com.builder.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.builder.bean.GeneratorConfiguration;
import com.builder.bean.JavaModelGenerator;
import com.builder.bean.SqlMapGenerator;
import com.builder.bean.Table;

import net.sf.json.xml.XMLSerializer;

public class ParseXmlUtil {

    public GeneratorConfiguration xmlLoadToBean(String filePath) {
        GeneratorConfiguration gc = null;

        try {
            InputStream is = new FileInputStream(new File(filePath));
            String xml = IOUtils.toString(is);

            XMLSerializer xmlSerializer = new XMLSerializer();
            net.sf.json.JSON json = xmlSerializer.read(xml);
            System.out.println(json.toString(2));
            gc = printJSONToBean(json.toString(2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gc;

    }

    public GeneratorConfiguration printJSONToBean(String jsonString) {
        GeneratorConfiguration gc = new GeneratorConfiguration();
        jsonString = jsonString.replaceAll("@", ""); //自动转成的所有的@都替换掉
        //gc=JSONObject.parseObject(jsonString, GeneratorConfiguration.class);
        List<Context> contexts = new ArrayList<Context>();
//        JSONObject jo = (JSONObject) JSONObject.parse(jsonString);

        JSONArray contextArray = JSONArray.parseArray(jsonString);
//        if (jo.get("context") instanceof JSONArray) {
//            contextArray = jo.getJSONArray("context");
//        } else if (jo.get("context") instanceof JSONObject) {
//            JSONObject contextJo = (JSONObject) jo.get("context");
//            contextArray = new JSONArray();
//            contextArray.add(contextJo);
//        }

        for (int i = 0; i < contextArray.size(); i++) {
            JSONObject contextJo = contextArray.getJSONObject(i);
            Context context = new Context();
            context.setId(contextJo.getString("id"));
            context.setTargetRuntime(contextJo.getString("targetRuntime"));
            //JavaModelGenerator
            JavaModelGenerator jmg = contextJo.getObject("javaModelGenerator", JavaModelGenerator.class);
            context.setJavaModelGenerator(jmg);

            //SqlMapGenerator
            SqlMapGenerator smg = contextJo.getObject("sqlMapGenerator", SqlMapGenerator.class);
            context.setSqlMapGenerator(smg);

            //tables
            List<Table> tables = new ArrayList<Table>();
            Object obj = contextJo.get("table");
            if (obj instanceof JSONObject) {
                Table table = JSONObject.parseObject(((JSONObject) obj).toJSONString(), Table.class);
                tables.add(table);
            } else if (obj instanceof JSONArray) {
                tables = JSON.parseArray(((JSONArray) obj).toJSONString(), Table.class);
            }
            context.setTables(tables);
            contexts.add(context);
        }
        gc.setContexts(contexts);
        return gc;
    }

    @Deprecated
    private static void printJSON(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> jsonInMap = mapper.readValue(jsonString,
                    new TypeReference<Map<String, Object>>() {
                    });

            List<String> keys = new ArrayList<String>(jsonInMap.keySet());
            System.out.println("map获取key-value开始！");
            for (String key : keys) {
                System.out.println(key + ": " + jsonInMap.get(key));
            }
            System.out.println("map获取key-value结束！");

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        ParseXmlUtil pu = new ParseXmlUtil();
        pu.xmlLoadToBean("generator.xml");

    }


}
