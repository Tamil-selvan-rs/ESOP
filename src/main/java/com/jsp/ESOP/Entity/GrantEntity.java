package com.jsp.ESOP.Entity;

import com.jsp.ESOP.DTO.GrantDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Entity
@NoArgsConstructor
@Table(name = "emp_table_master")
public class GrantEntity {
    @Id
    @Column(name = "alt_Key")
    private BigInteger altKey;
    @Column(name = "emp_id")
    private BigInteger empId;
    @Column(name = "grant_number")
    private Long grantNumber;
    @Column(name = "grant_price")
    private Double grantPrice;
    @Column( name = "grant_status")
    private String grantStatus="PENDING";
    @Column(name = "allocation_status")
    private String allocationStatus="PENDING";
    @Column(name = "is_accepted")
    private String isAccepted="No";
    @Column(name = "accepted_date")
    private Date acceptedDate;
    @Column(name = "frequncy")
    private Long frequency;
    @Column(name = "plan_id")
    private BigInteger planId;
    @Column(name = "grant_date")
    private Date grantDate;
    @Column(name = "created_date")
    private Date createdDate = new Date();
    @Column(name = "modified_date")
    private Date modifiedDate;

    public GrantEntity(GrantDto grantDto) {

        this.altKey=generateRandomNumber();
    this.grantNumber=grantDto.getGrantNumber();
    this.grantPrice=grantDto.getGrantPrice();
    this.empId = grantDto.getEmpId();
    this.frequency = grantDto.getFrequency();
    this.planId = grantDto.getPlanId();
    }

    private BigInteger generateRandomNumber()
    {
        return new BigInteger(ThreadLocalRandom.current().nextLong(500,999999)+"");
    }
}
