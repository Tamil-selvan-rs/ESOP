package com.jsp.ESOP.Service;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.GrantDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
@Service
public interface GrantService {
   AppResponseDto processCreateGrants(List<GrantDto> grants);
   AppResponseDto processGetAllGrants();
   AppResponseDto processGetGrantById(BigInteger id);
   AppResponseDto processFindByEmp(BigInteger empId);
   AppResponseDto processFindByPlan(BigInteger planId);
   AppResponseDto processFindByPlanIdAndGrantStatusAndAllocationStatus(BigInteger planId, String grantStatus, String allocationStatus);
   AppResponseDto processAcceptGrants(List<BigInteger> list);
   AppResponseDto processApprovetGrants(List<BigInteger> list);
   AppResponseDto processGetGrantsByPlanId(BigInteger planId);
}
