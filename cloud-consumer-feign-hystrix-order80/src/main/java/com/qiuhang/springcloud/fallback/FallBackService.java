package com.qiuhang.springcloud.fallback;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.fallback
 * @ClassName: FallBackService
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/19 9:42
 * @Version: 1.0
 */
@Component
public class FallBackService {
    public String paymentInfo_timeOutHandle(Integer id){

        return "服务异常  O(∩_∩)O";
    }
}
