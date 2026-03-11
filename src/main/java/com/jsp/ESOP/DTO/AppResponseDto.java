package com.jsp.ESOP.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppResponseDto {
    private String statusCode;
    private String errorMessage;
    private String status;
    private Object data;

}
