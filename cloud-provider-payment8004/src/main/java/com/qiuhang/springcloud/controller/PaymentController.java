package com.qiuhang.springcloud.controller;

import com.qiuhang.springcloud.entity.CommonResult;
import com.qiuhang.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.controller
 * @ClassName: PaymentController
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/10 10:07
 * @Version: 1.0
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
//    @Autowired
//    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/zk")
    public String getPaymentById(){
        return "zookeeper"+port;
    }


}
