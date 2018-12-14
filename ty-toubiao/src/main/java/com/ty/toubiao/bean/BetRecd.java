package com.ty.toubiao.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="t_bet_recd")
@Table
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class BetRecd implements Serializable {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="race_id")
    private String raceId;

    @Column(name="rebate_id")
    private Integer rebateId;

    @Column(name="bet_type")
    private Integer betType;

    @Column(name="bet_amount")
    private BigDecimal betAmount;

    @Column(name="bet_result")
    private Integer betResult;

    @Column(name="create_time")
    private Date createTime;

    @Column(name="update_time")
    private Date updateTime;

    @Column(name="rebate_status")
    private Integer rebateStatus;

    @Column(name="version")
    private Integer version;

}
