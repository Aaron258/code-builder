package com.builder.main;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.builder.util.FileUtil;

public class GeneratorSqlmap {
	public void generator(String path) throws Exception{
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(path); 
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback, warnings);
		myBatisGenerator.generate(null);

	} 
	public static void main(String[] args) throws Exception {
		FileUtil fileUtil = new FileUtil();
		String path = fileUtil.getResourceFilePathByName("config.xml");
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator(path);
			System.out.println("dao和model生成完毕");
			MainGenerator gcode2 = new MainGenerator();
//			gcode2.genService("/E:/Intellij/code-builder/target/classes/ge.xml");
			gcode2.genService(path);
			System.out.println("service、serviceImpl、controller代码生成完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
