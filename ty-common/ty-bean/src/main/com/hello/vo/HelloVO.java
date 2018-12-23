package com.hello.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: HELLO_VO
 * @date 2018/12/23 002314:55
 */
@Builder
@Data
@ApiModel
@NoArgsConstructor
@AllArgsConstructor
public class HelloVO implements Serializable {

    @ApiModelProperty(value = "用户名",required = true,example = "zhangsan")
    private String userName;

    @ApiModelProperty(value="密码",required = true,example = "mima123")
    private String passWord;

}
