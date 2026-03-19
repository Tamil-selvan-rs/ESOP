package com.jsp.ESOP.Service;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.PlanDto;

import java.math.BigInteger;

public interface PlanService {
    AppResponseDto processCreatePlan(PlanDto planDto);
    AppResponseDto processGetCurrentplan();
    AppResponseDto processUpdateMoetizationDate(BigInteger planId);
}
