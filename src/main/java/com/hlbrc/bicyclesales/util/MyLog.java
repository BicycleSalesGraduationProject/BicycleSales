package com.hlbrc.bicyclesales.util;

import org.apache.log4j.Logger;

public class MyLog {
	// ����ϣ��һ����Ŀֻ��һ����־�������Կ��Բ���static�����޸�
	//����һ����̬��Logger����
	public static Logger log ;
	static{
		log = Logger.getLogger(MyLog.class) ;
	}
}
