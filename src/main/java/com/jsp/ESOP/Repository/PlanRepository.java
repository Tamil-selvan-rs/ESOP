package com.jsp.ESOP.Repository;

import com.jsp.ESOP.Entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, BigInteger> {
}
