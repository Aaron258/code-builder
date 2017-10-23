package org.mybatis.generator.plugins.comment;

import java.util.Properties;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MyCommentGenerator implements CommentGenerator {


    public void addConfigurationProperties(Properties properties) {

    }


    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
            // addJavadocTag(field, false);
            //field.addJavaDocLine(" * @author Aaron");
            field.addJavaDocLine(" */");
        }
    }


    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {


    }


    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {

    }


    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

    }


    public void addEnumComment(InnerEnum innerEnum,
                               IntrospectedTable introspectedTable) {

    }


    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

    }


    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

    }


    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {

    }


    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }


    public void addComment(XmlElement xmlElement) {

    }


    public void addRootComment(XmlElement rootElement) {

    }

}
