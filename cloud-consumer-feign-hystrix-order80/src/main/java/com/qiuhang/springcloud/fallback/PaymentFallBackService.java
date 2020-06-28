package com.qiuhang.springcloud.fallback;

import com.qiuhang.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.fallback
 * @ClassName: PaymentFallBackService
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/22 16:01
 * @Version: 1.0
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK fallback";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut fallback";
    }
}
