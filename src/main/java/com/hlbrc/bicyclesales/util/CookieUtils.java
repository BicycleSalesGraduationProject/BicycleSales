package com.hlbrc.bicyclesales.util;

import org.slf4j.Logger;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * Cookie 工具类
 *
 */
public final class CookieUtils {

	/**
     * 设置HttpOnly Cookie
     * @param response HTTP响应
     * @param cookie Cookie对象
     * @param isHTTPOnly 是否为HttpOnly
     */
    public static void addCookie(HttpServletResponse response, Cookie cookie, boolean isHttpOnly) {
        String name = cookie.getName();//Cookie名称
        String value = cookie.getValue();//Cookie值
        int maxAge = cookie.getMaxAge();//最大生存时间(毫秒,0代表删除,-1代表与浏览器会话一致)
        String path = cookie.getPath();//路径
        String domain = cookie.getDomain();//域
        boolean isSecure = cookie.getSecure();//是否为安全协议信息 

        StringBuilder buffer = new StringBuilder();

        buffer.append(name).append("=").append(value).append(";");

        if (maxAge == 0) {
            buffer.append("Expires=Thu Jan 01 08:00:00 CST 1970;");
        } else if (maxAge > 0) {
            buffer.append("Max-Age=").append(maxAge).append(";");
        }

        if (domain != null) {
            buffer.append("domain=").append(domain).append(";");
        }

        if (path != null) {
            buffer.append("path=").append(path).append(";");
        }

        if (isSecure) {
            buffer.append("secure;");
        }

        if (isHttpOnly) {
            buffer.append("HTTPOnly;");
        }

        response.addHeader("Set-Cookie", buffer.toString());
    }
    /**
     * 得到Cookie的值, 不编码
     * 
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        return getCookieValue(request, cookieName, false);
    }

    /**
     * 得到Cookie的值,
     * 
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, boolean isDecoder) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValue = URLDecoder.decode(cookieList[i].getValue(), "UTF-8");
                    } else {
                        retValue = cookieList[i].getValue();
                    }
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 得到Cookie的值,
     * 
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName, String encodeString) {
        Cookie[] cookieList = request.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValue = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    retValue = URLDecoder.decode(cookieList[i].getValue(), encodeString);
                    break;
                }
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
//          e.printStackTrace();
        }
        return retValue;
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue) {
        setCookie(request, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码
     */
    public static void setCookieTwo(String domian, HttpServletResponse response, String cookieName,
                                 String cookieValue) {
        setCookieTwo(domian, response, cookieName, cookieValue, -1);
    }

    /**
     * 设置Cookie的值 在指定时间内生效,但不编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage) {
        setCookie(request, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值 在指定时间内生效,但不编码
     */
    public static void setCookieTwo(String domain, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage) {
        setCookieTwo(domain, response, cookieName, cookieValue, cookieMaxage, false);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数
     */
    public static void setCookieTwo(String  domain, HttpServletResponse response, String cookieName,
                                 String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookieTwo(domain, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     *
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookieTwo(String domain, HttpServletResponse response,
                                          String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
            cookie.setMaxAge(cookieMaxage);
            String domainName = getDomainNameByUrl(domain);
            if (!"localhost".equals(domainName)) {
                cookie.setDomain(domainName);
            }
            cookie.setPath("/");
//            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (Exception e) {
//            logger.error("doSetCookie错误信息:{}",e);
            throw new RuntimeException(e);
//          e.printStackTrace();
        }
    }

    /**
     * 得到cookie的域名
     */
    public static final String getDomainNameByUrl(String domain) {
        String domainName = null;

        String serverName = domain;
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
//            serverName = serverName.toLowerCase();
//            serverName = serverName.substring(7);
//            final int end = serverName.indexOf("/");
            serverName = domain;
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName =  "."+domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

    /**
     * 设置Cookie的值 不设置生效时间,但编码
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, boolean isEncode) {
        setCookie(request, response, cookieName, cookieValue, -1, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, boolean isEncode) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, isEncode);
    }

    /**
     * 设置Cookie的值 在指定时间内生效, 编码参数(指定编码)
     */
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
            String cookieValue, int cookieMaxage, String encodeString) {
        doSetCookie(request, response, cookieName, cookieValue, cookieMaxage, encodeString);
    }

    /**
     * 删除Cookie带cookie域名
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName) {
        doSetCookie(request, response, cookieName, "", -1, false);
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     * 
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, boolean isEncode) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else if (isEncode) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request) {// 设置域名的cookie
               String domainName = getDomainName(request);
                if (!"localhost".equals(domainName)) {
                   cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
//            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        } catch (Exception e) {
//            logger.error("doSetCookie错误信息:{}",e);
            throw new RuntimeException(e);
//          e.printStackTrace();
        }
    }

    /**
     * 设置Cookie的值，并使其在指定时间内生效
     * 
     * @param cookieMaxage cookie生效的最大秒数
     */
    private static final void doSetCookie(HttpServletRequest request, HttpServletResponse response,
            String cookieName, String cookieValue, int cookieMaxage, String encodeString) {
        try {
            if (cookieValue == null) {
                cookieValue = "";
            } else {
                cookieValue = URLEncoder.encode(cookieValue, encodeString);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxage > 0)
                cookie.setMaxAge(cookieMaxage);
            if (null != request) {// 设置域名的cookie
               String domainName = getDomainName(request);
               System.out.println(domainName);
                if (!"localhost".equals(domainName)) {
                   cookie.setDomain(domainName);
                }
            }
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
//            logger.error("doSetCookie错误信息:{}",e);
            throw new RuntimeException(e);
//          e.printStackTrace();
        }
    }

    /**
     * 得到cookie的域名
     */
    public static final String getDomainName(HttpServletRequest request) {
        String domainName = null;

        String serverName = request.getRequestURL().toString();
        if (serverName == null || serverName.equals("")) {
            domainName = "";
        } else {
            serverName = serverName.toLowerCase();
            serverName = serverName.substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");
            int len = domains.length;
            if (len > 3) {
                // www.xxx.com.cn
                domainName = domains[len - 3] + "." + domains[len - 2] + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
                // xxx.com or xxx.cn
                domainName = domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != null && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}