package com.jsp.ESOP.Repository;

import com.jsp.ESOP.Entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, BigInteger> {
    @Modifying
    @Query(value = "SELECT g.alt_key, SUM(a.allocation_number) AS allocation_sum" +
            " FROM allocation_master a LEFT OUTER JOIN emp_table_master g ON a.grant_id = g.alt_key " +
            "WHERE g.plan_id = :pId AND a.status = 'APPROVED' GROUP BY g.alt_key", nativeQuery = true)
    List<Map<String,Object>> findGrantsByPlanId(@Param("pId") BigInteger planId);

    @Query(value = "select altKey from PlanEntity Where isCurrentPlan = true")
    BigInteger findCurrentPlan();
@Modifying
@Transactional
@Query(value = "update PlanEntity set monitaizationDate = :md where altKey= :pid")
    int updateMonetizationDate(@Param("md")Date monetizationDate,@Param("pid") BigInteger planId);
}
