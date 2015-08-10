package com.smartlab.oa.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class LogTest {
   
	private Log log = LogFactory.getLog(this.getClass());
	
	//日志错误信息优先级
	@Test
	public void test() throws Exception{
		log.debug("这是debug信息");
		log.info("这是info信息");
		log.warn("这是warn信息");
		log.error("这是error信息");  //在log4j.properties文件中设置log4j.rootLogger=error, stdout
		log.fatal("这是fatal信息");
		
		//log4j.logger.com.smartlab.oa=debug 这个包中的错误日志信息模式为debug
	}
	
}
