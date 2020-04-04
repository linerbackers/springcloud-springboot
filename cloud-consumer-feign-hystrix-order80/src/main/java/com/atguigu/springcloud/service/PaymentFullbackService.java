package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 用来做对8001服务端调用失败的统一全局降级处理
 */
@Component
public class PaymentFullbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK_PaymentFullback_error";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut_PaymentFullback_error";
    }
}
