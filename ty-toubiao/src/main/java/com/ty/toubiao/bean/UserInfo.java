package com.ty.toubiao.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="t_user_info")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer userId;
    @Column(name="nick_name")
    private String nickName;
    @Column(name="account")
    private String account;
    @Column(name="icon_url")
    private String iconUrl;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="phone_area_code")
    private String phoneAreaCode;
    @Column(name="invite_code")
    private String inviteCode;
    @Column(name="nationality")
    private String nationality;
    @Column(name="sys_status")
    private Byte sysStatus;
    @Column(name="regist_time")
    private Date registTime;
    @Column(name="login_pwd")
    private String loginPwd;
    @Column(name="last_login_time")
    private Date lastLoginTime;
    @Column(name="update_time")
    private Date updateTime;
    @Column(name="opt_status")
    private Byte optStatus;
    @Column(name="opt_reason")
    private String optReason;
    @Column(name="proxy")
    private Integer proxy;
    @Column(name="fund_password")
    private String fundPassword;

}