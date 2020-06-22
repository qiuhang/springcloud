package com.qiuhang.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: cloud2020
 * @Package: com.qiuhang.springcloud.entity
 * @ClassName: CommonResult
 * @Author: qiuhang
 * @Description: ${description}
 * @Date: 2020/6/9 17:09
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this.code=code;
        this.message=message;
    }
}
