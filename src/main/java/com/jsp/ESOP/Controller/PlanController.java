package com.jsp.ESOP.Controller;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.PlanDto;
import com.jsp.ESOP.Service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
public class PlanController {

    @Autowired
    private PlanService planService;
    @RequestMapping(value = "/createplan")
    public AppResponseDto createPlan(@RequestBody PlanDto planDto) {
     return planService.processCreatePlan(planDto);
    }
    @GetMapping("/currentPlanId")
    public AppResponseDto getCurrentPlanId() {
    return planService.processGetCurrentplan();
    }
    @PutMapping("/updateMonetizationDate/{planId}")
    public AppResponseDto updateMonetizationDate(@PathVariable("planId")BigInteger planId) {
        return planService.processUpdateMoetizationDate(planId);
    }
}
