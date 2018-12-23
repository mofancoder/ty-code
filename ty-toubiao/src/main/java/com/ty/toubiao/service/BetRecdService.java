package com.ty.toubiao.service;

import com.ty.toubiao.bean.BetRecd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * BetRecd jpa service
 */
@Service
public interface BetRecdService extends JpaRepository<BetRecd, BigInteger>, JpaSpecificationExecutor<BetRecd>, Serializable {


}
