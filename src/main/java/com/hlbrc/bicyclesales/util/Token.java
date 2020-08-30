package com.hlbrc.bicyclesales.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class Token {
	/**** 设置令牌* @param request */
	public static void setToken(HttpServletRequest request) {
		String sessionToken = UUID.randomUUID().toString();
		request.getSession().setAttribute("SesToken", sessionToken);
		System.out.println("令牌设置setToken，令牌："+sessionToken);
	}
	public static String getToken(HttpServletRequest request)
	{
		String sessionToken = (String)request.getSession().getAttribute("SesToken");
		if(null == sessionToken || "".equals(sessionToken))
		{
			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",sessionToken );
			System.out.println("令牌设置getToken，令牌："+sessionToken);
		}
		return sessionToken;
	}
	/**** 验证是否为重复提交
	 * @param HttpServletRequest request
	 * @return String true非重复提交,false重复提交,error非法操作
	 */
	public static String validToken(HttpServletRequest request){
		String sessionToken = (String)request.getSession().getAttribute("SesToken");
		System.out.println("效验令牌，当前令牌："+sessionToken);
		String requestToken = request.getParameter("SesToken");
		if(null == sessionToken  || "null".equals(sessionToken)){
			sessionToken = "";
		}
		if(null == requestToken || "null".equals(requestToken) )
		{
			requestToken = "";
		}
		if(sessionToken.equals(requestToken)){
			//返回前一定要重置session中的SesToken
			String my_take = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",my_take);
			System.out.println("效验令牌：非重复提交，令牌："+my_take);
			//非重复提交
			return "true";
		}
		else{
			//返回前一定要重置session中的SesToken
			String my_take = UUID.randomUUID().toString();
			request.getSession().setAttribute("SesToken",my_take);
			//重复提交
			System.out.println("效验令牌：重复提交，令牌："+my_take);
			return "false";
		}
	}

		
}
