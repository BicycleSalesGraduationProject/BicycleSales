package com.hlbrc.bicyclesales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hlbrc.bicyclesales.util.AlipayConfig;


@Controller
public class AlipayController {
	
	@RequestMapping(value = "alipayTradeFastpayRefundQuery")
    @ResponseBody
    public String alipayTradeFastpayRefundQuery(){
//		//获得初始化的AlipayClient
//		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
//		
//		//设置请求参数
//		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
//		
//		//商户订单号，商户网站订单系统中唯一订单号
//		String out_trade_no = new String(request.getParameter("WIDRQout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//		//支付宝交易号
//		String trade_no = new String(request.getParameter("WIDRQtrade_no").getBytes("ISO-8859-1"),"UTF-8");
//		//请二选一设置
//		//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
//		String out_request_no = new String(request.getParameter("WIDRQout_request_no").getBytes("ISO-8859-1"),"UTF-8");
//		
//		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
//				+"\"trade_no\":\""+ trade_no +"\","
//				+"\"out_request_no\":\""+ out_request_no +"\"}");
//		
//		//请求
//		String result = alipayClient.execute(alipayRequest).getBody();
    	return "";
    }
}
