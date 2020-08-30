package com.hlbrc.bicyclesales.util;

import org.apache.log4j.Logger;

public class MyLog {
	// 我们希望一个项目只有一个日志对象所以可以采用static来做修改
	//定义一个静态的Logger对象
	public static Logger log ;
	static{
		log = Logger.getLogger(MyLog.class) ;
	}
}
