package com.jsp.ESOP.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Data
@Table(name = "plan_master")
public class PlanEntity {
    @Id
    @Column(name = "alt_key")
    private BigInteger altKey;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "is_current_plan")
    private Boolean isCurrentPlan;
    @Column(name = "vesting_factor")
    private Double vestingFactor;
    @Column(name = "monitaization_date")
    private Date monitaizationDate;


}
