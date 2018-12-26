package com.ty.toubiao.dao;

import com.ty.toubiao.bean.BetRecd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * BetRecd jpa service
 */
@Repository
public interface BetRecdRepository extends JpaRepository<BetRecd, BigInteger>, JpaSpecificationExecutor<BetRecd>, Serializable {


}
