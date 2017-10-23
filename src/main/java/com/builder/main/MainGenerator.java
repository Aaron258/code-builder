package com.builder.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import com.builder.bean.GeneratorConfiguration;
import com.builder.bean.JavaModelGenerator;
import com.builder.bean.SqlMapGenerator;
import com.builder.bean.Table;
import com.builder.util.FreeMarkerGenUtil;
import com.builder.util.ParseXmlUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MainGenerator {

    /**
     * @param filePath mybatis配置文件路径
     */
    public void genService(String filePath) throws IOException, XMLParserException {
        List<String> warnings = new ArrayList<String>();
        File configFile = new File(filePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        List<Context> contexts = config.getContexts();
        for (Context context : contexts) {
            JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
            String targetPackage = javaModelGeneratorConfiguration.getTargetPackage(); //类似包名com.htjx.resource.category.model
            String targetProject = javaModelGeneratorConfiguration.getTargetProject();//代码存放路径

            //创建目录，根据domainObjectName名生成代码。
            String prefixPackageName = targetPackage.substring(0, targetPackage.lastIndexOf(".")); //得到类似包名 com.htjx.resource.category
            String packagePath = prefixPackageName.replaceAll("\\.", Matcher.quoteReplacement("\\")); //包名转成路径
            String absolutePath = targetProject + File.separator + packagePath;//绝对路径

            //com.zgg.user.base.api
            String servicePath = absolutePath + "\\api";
            String serviceImplPath = absolutePath + "\\impl";
            String servicePretendPath = absolutePath + "\\service";
            String controllerPath = absolutePath + "\\controller";
            String testPath = absolutePath + "\\test";

            String servicePackageName = prefixPackageName + ".api";
            String serviceImplPackageName = prefixPackageName + ".impl";
            String servicePretendPackageName = prefixPackageName + ".service";
            String controllerPackageName = prefixPackageName + ".controller";
            String testPackageName = prefixPackageName + ".test";
            //取moduleName
            String moduleName = "";
            String[] arr = targetPackage.split("\\.");
            if (arr.length > 2) {
                moduleName = arr[2];
            }

            mkdir(servicePath);
            mkdir(serviceImplPath);
            mkdir(servicePretendPath);
            mkdir(controllerPath);
            mkdir(testPath);

            List<TableConfiguration> tableConfigurations = context.getTableConfigurations();
            for (TableConfiguration tableConfiguration : tableConfigurations) {
                String domainObjectName = tableConfiguration.getDomainObjectName();
                String alias = tableConfiguration.getTableComment();
                // 开始生成service
                Map<String, String> serviceMap = new HashMap<String, String>();
                serviceMap.put("domainObjectName", domainObjectName);
                serviceMap.put("alias", alias);
                //vo变量首字母小写
                String firstLetter = domainObjectName.substring(0, 1);
                firstLetter = firstLetter.toLowerCase();//转小写
                String domainObjectNameSuffix = domainObjectName.substring(1);
                String domainObjectNameLower = firstLetter + domainObjectNameSuffix;
                serviceMap.put("domainObjectNameLower", domainObjectNameLower);
                serviceMap.put("packageName", servicePackageName);
                serviceMap.put("prefixPackageName", prefixPackageName);
                FreeMarkerGenUtil fmgu = new FreeMarkerGenUtil();
                String serviceFileName = servicePath + File.separator + domainObjectName + "Service.java";
                fmgu.genCode(serviceMap, serviceFileName, "template\\service.ftl");

                //生成service实现类
                serviceMap.put("packageName", serviceImplPackageName);
                serviceMap.put("moduleName", moduleName);
                serviceMap.put("prefixPackageName", prefixPackageName);
                String serviceImplFileName = serviceImplPath + File.separator + domainObjectName + "ServiceImpl.java";
                fmgu.genCode(serviceMap, serviceImplFileName, "template\\serviceImpl.ftl");

                //生成service pentend聚合层
                serviceMap.put("packageName", servicePretendPackageName);
                serviceMap.put("moduleName", moduleName);
                serviceMap.put("prefixPackageName", prefixPackageName);
                String servicePentendFileName = servicePretendPath + File.separator + domainObjectName + "ServicePretend.java";
                fmgu.genCode(serviceMap, servicePentendFileName, "template\\pretend.ftl");

                //生成controller
                serviceMap.put("packageName", controllerPackageName);
                serviceMap.put("moduleName", moduleName);
                serviceMap.put("prefixPackageName", prefixPackageName);
                String controllerFileName = controllerPath + File.separator + domainObjectName + "Controller.java";
                fmgu.genCode(serviceMap, controllerFileName, "template\\controller.ftl");


                //生成单元测试
                serviceMap.put("packageName", testPackageName);
                serviceMap.put("moduleName", moduleName);
                serviceMap.put("prefixPackageName", prefixPackageName);
                String testFileName = testPath + File.separator + domainObjectName + "Test.java";
                fmgu.genCode(serviceMap, testFileName, "template\\test.ftl");

                //生成jsp文件

            }
        }
    }


    /**
     * 生成jsp文件
     *
     * @param sqlMapGenerator
     * @param domainObjectName 类似：SoftCategory
     * @param absolutePath     类似 F:\datafile\src\com\htjx\resource\category
     * @param targetProject    类似 F:\datafile\src
     */
    private void genJsp(SqlMapGenerator sqlMapGenerator, String domainObjectName, String absolutePath, String targetProject) {
        String jspPath = absolutePath + "\\jsp";
        String mappingPackageName = sqlMapGenerator.getTargetPackage();
        String packagePath = mappingPackageName.replaceAll("\\.", Matcher.quoteReplacement("\\")); //包名转成路径
        String mappingAbsolutePath = targetProject + File.separator + packagePath; //mapping文件绝对路径。类似：F:\datafile\src\com\htjx\resource\category\mapping
        String mappingFileAbsolutePath = mappingAbsolutePath + File.separator + domainObjectName + "Mapper.xml";
        //读取xml，找到resultMap并读取，转换成对象，再根据不同字段类型生成不同表单元素。

    }

    private void mkdir(String filePath) {
        File serviceFile = new File(filePath);
        if (!serviceFile.exists()) {
            serviceFile.mkdirs();
        }
    }
}
