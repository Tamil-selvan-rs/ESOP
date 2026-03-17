package com.jsp.ESOP.Service;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.PlanDto;

public interface PlanService {
    AppResponseDto processCreatePlan(PlanDto planDto);
    AppResponseDto processGetCurrentplan();
}
