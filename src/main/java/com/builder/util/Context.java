package com.builder.util;

import java.util.List;

import com.builder.bean.JavaModelGenerator;
import com.builder.bean.SqlMapGenerator;
import com.builder.bean.Table;

public class Context {

    private String id;
    private String targetRuntime;
    private JavaModelGenerator javaModelGenerator;
    private SqlMapGenerator sqlMapGenerator;
    private List<Table> tables;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetRuntime() {
        return targetRuntime;
    }

    public void setTargetRuntime(String targetRuntime) {
        this.targetRuntime = targetRuntime;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public JavaModelGenerator getJavaModelGenerator() {
        return javaModelGenerator;
    }

    public void setJavaModelGenerator(JavaModelGenerator javaModelGenerator) {
        this.javaModelGenerator = javaModelGenerator;
    }

    public SqlMapGenerator getSqlMapGenerator() {
        return sqlMapGenerator;
    }

    public void setSqlMapGenerator(SqlMapGenerator sqlMapGenerator) {
        this.sqlMapGenerator = sqlMapGenerator;
    }


}
