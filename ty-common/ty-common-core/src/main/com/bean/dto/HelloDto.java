package com.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: HELLO测试数据库DTO对象
 * @date 2018/12/23 002315:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ty_hello")
@Table
public class HelloDto {

    //自动生成id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String guid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

}
