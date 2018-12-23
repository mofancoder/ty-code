package com.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author MOFAN889
 * @ProjectName ty-core
 * @Description: TODO
 * @date 2018/12/23 002315:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ty_hello")
public class HelloDto {

    @Id
    //自动生成id
    @GeneratedValue
    private String guid;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pass_word")
    private String passWord;

}
