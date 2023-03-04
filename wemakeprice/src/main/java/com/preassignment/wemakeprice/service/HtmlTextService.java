package com.preassignment.wemakeprice.service;

import com.preassignment.wemakeprice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class HtmlTextService {
    private final CommonService commonService;

    public ResponseDto getQuotientAndRemainder(String url, String type, Integer unit) {
//        String htmlSource = getPageHtmlSourceByUrl(url);
        String htmlSource = "<https>://Www.nAavErR.com/42133740";

        String text = "";
        switch (type) {
            case "HTML":
                text = getStringWhenRemoveHtml(htmlSource);
                break;
            case "TEXT":
                text = getStringWhenAllText(htmlSource);
                break;
            default:
                throw new RuntimeException("");
        }

        return getQuotientAndRemainder(text, unit);
    }

    // URI로 HTML Source 데이터 추출
    private String getPageHtmlSourceByUrl(String url) {
        return "";
    }

    // HTML 태그 제외 문자열
    private String getStringWhenRemoveHtml(String htmlSource) {
        String engText = htmlSource.replaceAll("<(/)?([a-zA-Z]*)(\\\\s[a-zA-Z]*=[^>]*)?(\\\\s)*(/)?>", "");
        engText = engText.replaceAll("[^a-zA-Z]", "");
        String number = htmlSource.replaceAll("[^0-9]", "");

        log.info(engText);
        log.info(number);

        return commonService.sortAndIntersectArrays(engText, number);
    }

    // Text 전체 문자열
    private String getStringWhenAllText(String htmlSource) {
        String english = htmlSource.replaceAll("[^a-zA-Z]", "");
        String number = htmlSource.replaceAll("[^0-9]", "");

        log.info(english);
        log.info(number);

        return commonService.sortAndIntersectArrays(english, number);
    }

    //몫, 나머지 문자열 반환
    private ResponseDto getQuotientAndRemainder(String text, Integer unit) {
        String quotient = "";
        String remainder = "";

        if (unit == 1 || text.length() % unit == 0 )
            return ResponseDto.builder()
                    .quotient(text)
                    .remainder("")
                    .build();
        else {
            int r = text.length() % unit;
            int q = text.length() - r;

            for(int i = 0; i < q; i++){
                quotient += text.charAt(i) + "";
            }
            for (int i = text.length()-r; i < text.length(); i++) {
                remainder += text.charAt(i);
            }
        }

        return ResponseDto.builder()
                .quotient(quotient)
                .remainder(remainder)
                .build();
    }
}
