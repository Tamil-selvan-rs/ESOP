package com.jsp.ESOP.Service;

import com.jsp.ESOP.DTO.AppResponseDto;
import com.jsp.ESOP.DTO.PlanDto;
import com.jsp.ESOP.Entity.PlanEntity;
import com.jsp.ESOP.Repository.PlanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public AppResponseDto processCreatePlan(PlanDto planDto) {
        try {
            PlanEntity planEntity = new PlanEntity();
            BeanUtils.copyProperties(planDto, planEntity);
            planEntity.setAltKey(new BigInteger("" + Math.abs(ThreadLocalRandom.current().nextLong())));

            return new AppResponseDto("200", null, "success", planRepository.save(planEntity));
        } catch (Exception e) {
            return new AppResponseDto("400", e.getMessage(), "Failed", null);
        }

    }

    @Override
    public AppResponseDto processGetCurrentplan() {
        try {
            return new AppResponseDto("200", null, "success", planRepository.findCurrentPlan());
        }catch (Exception e){
            return new AppResponseDto("400", e.getMessage(), "Failed", null);
        }
    }
}
