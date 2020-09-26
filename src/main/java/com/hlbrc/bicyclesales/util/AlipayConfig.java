package com.hlbrc.bicyclesales.util;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101700706515";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCd+NY0eJo0g9AxP9iydi0yxODQKij2xB3oRTGLi+rv20TS/ausa+36ZRgqsnPbrB1h3zf1tmXKXLwcnwmGTWIT6nZpbf5SqysheXwGE+GwtG1H5OwrgAI7Cs3oL0xJtXhbfmaqPhrDCd258fLCl+9ZnavlAIGTaR/vhd+55YC/v+voP2Jyl2xHdU8oZMhDNyWxks+mmuIVEg8dOYsd1OeYPzuaMN5FguwdK2K7Uv4MMbZRIGN2TRfIhxJJKJ+ClZIbAggRLn0MSJJtgIe0Ftky85eabJE4aT+yyQ4ul5d3cWGMltTIRlkQ98xkdIgjgrVqUMohHqnwJ6SIbAGQa4klAgMBAAECggEAPfg4p3rMG1++EyPVsSR01J6xBlgTm8IRbWV/axunPRKKLC7A4rGwOHLiCRXaJ0mceSFkxWoZAkpgrOWiieHfYKqwaulwRCPLlqUehw/TkEsnN3XRQ7tCpMC3R6cOSTf8EABE6/HS88HyDhigv790cHZO0VXift5VXdPpkPY8DHvwP85Ji4dRSgoRuMW/ZkszLxcrInNP2xGdjWW9TOXfHmxcIsIa+A0tTl3RPGhBUgvcoYtA33ZtgcynjQbnPcqer7bLbWbbEx5T23uvnZ3TsNLr878AgWGlwpwmkiFg1FIpZASOh4NFw8vG3tAUnmh6pVgn3ADk3c3Qlq3WIfqjgQKBgQDu/e1f12CB+mtdCTpsOyan+zT2aIW9epv94aO1Hab1djuJ9e+UbZJye+DHuJHS+hTSrU8MvGmgieb+mzEyZ+TdhTa5Z/FCbuhgRCFvPFKpopSWOVv35yOwV5K+tXKcRCpQGb4BNgUioqvtJ2O6ATbBLjcxSlHutK4SwyCcYcAiYQKBgQCpNtlhWs9jSs4F+AR4F3PxXfWhTfNYBUgbVu+Yxmdcd5hine33SJF+9j+bN7bTM62Yp7ZZei1DC2v0jiW/DGR8M61X63HHyzyJuwu4NvKqMf8vhBspUgwA7h4XfSDFA5c6z4r2Zv2tad6rmj1KnnobY8r/6Js7whMw/27Gx1JlRQKBgQCLTYdnLesa2BRsjkx3eaL2lv4wAoyx/R2fxj3d/AKtYNUjfS7AnX2XLY2/3F1jVFF+23YQPmJzKO5zyZHLh7NnS5ayS1vdFThtpEi4xbiJGDLzvUtWHGw5BVKLxsefPjxLpDWUDyC/J4J/IU6HxN1djMqu+Fr5gGdWmFYR0QhlAQKBgF6aa64iNxAsIkL0BoudkRTAkzM7gXEUgtvGHu4q/l6T/n4kDYbS64Uv5x/AZlZt7gAKw8gCpot1N0Xisve81fEacy9UUqiA17eo+0RidAjzKthF42mWlV9vwSMgsdFz0Hjwz6AytGDfb75A3UN6lon5oOSyBxfByTj7ldNMXKSBAoGBAJsNGGZQjNbVZ4OC7O2/AQJC3KHRVT1M3R9h8iqIoOCaN7WKnyT1KckxI/w6AGlFLufsqUkzaHtpJM3DjuToyK8uaVJSuwiUBJpKpWCa72iwcUZE3nIINR27xMkNSbL0Op9KkgQoXHtWdLdc3diFLa4XGl9rcx1lloy/rFl48a4s";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsfe5XGMHIJ6kMSxqfJ5O2hQs8OgGoXap3jsn1CeUP7t0FHoYEWdUuokjQR/NIUdAWQx9U0I4GqKJJ+pCm2lTuCJ/fXEEvMyJZSbzugw6/rtFhR+lKpRgjf+NMWRM630az+o/M0eOdXaiza+sEGjwKLAYqXjDw3aA89YpDF3livSmRJY8ySOW+p+Q1L+2beB5xdc71NVmAPX2fKKP8cB0qks6xzB3JvV+QVe91Leg1yOsjiSWi5LBOfuV3Y5reEUSEzUkm/hK2kV3AZJZpVx5i1GwZK91yw3GjamxI7EoOyzm8UhxJAxc8gpjaK7ZnyxBEQ/fX+MEuBjGnK/iCthcPQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://127.0.0.1:9090/BicycleSales/notifyUrl.do";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://127.0.0.1:9090/BicycleSales/retureUrl.do";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

