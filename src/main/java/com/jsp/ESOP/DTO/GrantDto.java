package com.jsp.ESOP.DTO;

import lombok.Data;

import java.math.BigInteger;

@Data
public class GrantDto {
    private BigInteger empId;
    private Long grantNumber;
    private Double grantPrice;
    private Long frequency;
    private BigInteger planId;
}
