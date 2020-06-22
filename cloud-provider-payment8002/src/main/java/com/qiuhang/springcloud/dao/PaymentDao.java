package com.qiuhang.springcloud.dao;

import com.qiuhang.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.dao
 * @ClassName: PaymentDao
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/10 9:41
 * @Version: 1.0
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
