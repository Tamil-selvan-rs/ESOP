package com.jsp.ESOP.Repository;

import com.jsp.ESOP.Entity.GrantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface GrantEmpRepository extends JpaRepository<GrantEntity, BigInteger> {
    @Query(value = "from GrantEntity where planId=:planId")
    List<GrantEntity> findByPlanId(BigInteger planId);

    GrantEntity findByEmpId(BigInteger empId);

    @Modifying
    @Query(value = "from GrantEntity Where planId=:pId and grantStatus=:gs and allocationStatus=:as")
    List<GrantEntity> findByPlanIdAndGrantStatusAndAllocationStatus(@Param("pId") BigInteger planId, @Param("gs") String grantStatus, @Param("as") String allocationStatus);

    @Transactional
    @Modifying
    @Query("update GrantEntity set grantStatus=:gs ,grantDate= :dt WHERE altKey IN :listOfAltKey")
    int updateGrantStatusAndGrantDate(@Param("gs")String grantStatus, @Param("dt") Date dt, @Param("listOfAltKey") List<BigInteger> listOfAltKey);

    @Transactional
    @Modifying
    @Query("update GrantEntity set isAccepted=:ac ,acceptedDate= :dt WHERE altKey IN :altKey")
    int updateIsAcceptedAndAcceptedDate(@Param("ac")String grantStatus, @Param("dt") Date dt, @Param("altKey") List<BigInteger> altKey);


    @Modifying
    @Query(value = "from GrantEntity Where planId=:pId and grantStatus='APPROVED' and allocationStatus='PENDING' and isAccepted='YES'")
    List<GrantEntity> getGrantsByPlanId(@Param("pId") BigInteger planId);

}
