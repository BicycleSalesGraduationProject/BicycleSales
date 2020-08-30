package com.hlbrc.bicyclesales.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Token {
	/**** ��������* @param request */
	public static void setToken(HttpServletRequest request) {
		String sessionToken = UUID.randomUUID().toString();
		request.getSession().setAttribute("SesToken", sessionToken);
		System.out.println("��������setToken�����ƣ�"+sessionToken);
	}
	public static String getToken(HttpServletRequest request)
	{
		String sessionToken = (String)request.getSession().getAttribute("SesToken");
		if(null == sessionToken || "".equals(sessionToken))
		{
			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",sessionToken );
			System.out.println("��������getToken�����ƣ�"+sessionToken);
		}
		return sessionToken;
	}
	/**** ��֤�Ƿ�Ϊ�ظ��ύ
	 * @param HttpServletRequest request
	 * @return String true���ظ��ύ,false�ظ��ύ,error�Ƿ�����
	 */
	public static String validToken(HttpServletRequest request){
		String sessionToken = (String)request.getSession().getAttribute("SesToken");
		System.out.println("Ч�����ƣ���ǰ���ƣ�"+sessionToken);
		String requestToken = request.getParameter("SesToken");
		if(null == sessionToken  || "null".equals(sessionToken)){
			sessionToken = "";
		}
		if(null == requestToken || "null".equals(requestToken) )
		{
			requestToken = "";
		}
		if(sessionToken.equals(requestToken)){
			//����ǰһ��Ҫ����session�е�SesToken
			String my_take = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",my_take);
			System.out.println("Ч�����ƣ����ظ��ύ�����ƣ�"+my_take);
			//���ظ��ύ
			return "true";
		}
		else{
			//����ǰһ��Ҫ����session�е�SesToken
			String my_take = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",my_take);
			//�ظ��ύ
			System.out.println("Ч�����ƣ��ظ��ύ�����ƣ�"+my_take);
			return "false";
		}
	}

		
}
