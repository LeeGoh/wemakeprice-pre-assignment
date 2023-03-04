package com.preassignment.wemakeprice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResponseDto {
    private String quotient;
    private String remainder;

    @Builder
    public ResponseDto(String quotient, String remainder) {
        this.quotient = quotient;
        this.remainder = remainder;
    }
}
