package com.yanger.generator.executer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.yanger.generator.core.GenConfig;
import com.yanger.generator.core.GenFileInfo;
import com.yanger.generator.schema.Table;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBatisCustomXmlExecuter extends BaseExecuter {
	private GenFileInfo mapperXmlInfo;
	private GenFileInfo daoInfo;

	public MyBatisCustomXmlExecuter(GenConfig genConfig, GenFileInfo mapperXmlInfo, GenFileInfo daoInfo) {
		super(genConfig);
		this.mapperXmlInfo = mapperXmlInfo;
		this.daoInfo = daoInfo;
	}

	public void build(Table table) throws IOException {
		File mapperXmlFile = new File(mapperXmlInfo.getPath(), mapperXmlInfo.getName() + XML_SUFFIX);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mapperXmlFile)))) {
			bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			bw.newLine();
			bw.write(
					"<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
			bw.newLine();
			bw.write("<!-- ============================================================== -->");
			bw.newLine();
			bw.write("<!-- ================可直接使用Base配置文件中定义的节点！================ -->");
			bw.newLine();
			bw.write("<!-- ============================================================== -->");
			bw.newLine();
			bw.write("<mapper namespace=\"" + daoInfo.getPackageName() + "." + daoInfo.getName() + "\">");
			bw.newLine();

			bw.write("  <!-- 请在下方添加自定义配置-->");
			bw.newLine();
			bw.newLine();
			bw.newLine();
			bw.write("</mapper>");
			bw.flush(); 
		}
		log.info("Generate Xml file " + mapperXmlFile.getAbsolutePath());
	}

}
