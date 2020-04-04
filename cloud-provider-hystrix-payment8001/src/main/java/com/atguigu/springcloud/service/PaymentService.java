package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    /**
     * 正常访问测试
     *
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 延时访问测试
     *
     * @param id
     * @return
     */
    String paymentInfo_Timeout(Integer id);


    String paymentCircuitBreaker(Integer id);
}
