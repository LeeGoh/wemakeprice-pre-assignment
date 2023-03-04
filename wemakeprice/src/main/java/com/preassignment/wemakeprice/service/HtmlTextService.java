package com.preassignment.wemakeprice.service;

import com.preassignment.wemakeprice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HtmlTextService {
    private final CommonService commonService;
    private final HtmlSourceCallService htmlSourceCallService;

    public ResponseDto getQuotientAndRemainder(String url, String type, Integer unit) {
        String htmlSource = htmlSourceCallService.getPageHtmlSourceByUrl(url);

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

        System.out.println("-----");
        log.info(text);
        System.out.println("-----");

        return getQuotientAndRemainder(text, unit);
    }

    // HTML 태그 제외 문자열
    private String getStringWhenRemoveHtml(String htmlSource) {
        String engText = htmlSource.replaceAll("<[^>]*>", "");
        engText = engText.replaceAll("[^a-zA-Z]", "");
        String number = htmlSource.replaceAll("[^0-9]", "");

        return commonService.intersectArrays(engText, number);
    }

    // Text 전체 문자열
    private String getStringWhenAllText(String htmlSource) {
        String english = htmlSource.replaceAll("[^a-zA-Z]", "");
        String number = htmlSource.replaceAll("[^0-9]", "");

        return commonService.intersectArrays(english, number);
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

            System.out.println("-----");
            log.info(quotient);
            log.info(remainder);
            System.out.println("-----");
        }

        return ResponseDto.builder()
                .quotient(quotient)
                .remainder(remainder)
                .build();
    }
}
