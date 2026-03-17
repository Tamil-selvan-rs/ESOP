package com.jsp.ESOP.DTO;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class PlanDto {
    private Date startDate;
    private Date endDate;
    private Boolean isCurrentPlan;
    private Double vestingFactor;
    private Date monitaizationDate;
}
