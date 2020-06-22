package com.qiuhang.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.entity
 * @ClassName: Payment
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/9 17:07
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;

}
