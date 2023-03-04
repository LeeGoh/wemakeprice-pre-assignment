package com.preassignment.wemakeprice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class CommonService {
    // 배열 정렬 및 교차 출력
    public String sortAndIntersectArrays(String english, String number) {
        String[] englishArr = stringDuplicate(english);
        String[] numberArr = stringDuplicate(number);

        String text = "";
        if (englishArr.length >= numberArr.length) {
            for (int i = 0; i < englishArr.length; i++) {
                text += englishArr[i];
                if (i < numberArr.length) text += numberArr[i];
            }
        } else {
            for (int i = 0; i < numberArr.length; i++) {
                if (i < englishArr.length) text += englishArr[i];
                text += numberArr[i];
            }
        }

        return text;
    }

    // 문자열 중복 제거 메서드
    public String[] stringDuplicate(String str) {
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == i)
                s += str.charAt(i);
        }

        String[] deduplicate = s.split("");
        Arrays.sort(deduplicate);
        Arrays.sort(deduplicate, String.CASE_INSENSITIVE_ORDER);

        return deduplicate;
    }
}
