package com.preassignment.wemakeprice.service;

import com.preassignment.wemakeprice.survlet.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HtmlTextService {
    public ResponseDto getQuotientAndRemainder(String url, String type, Integer unit) {
        return ResponseDto.builder().build();
    }
}
