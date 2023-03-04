package com.preassignment.wemakeprice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class CommonService {
    // 배열 교차 출력
    public String intersectArrays(String english, String number) {
        String[] englishArr = sortArrays(english);
        String[] numberArr = sortArrays(number);

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

    // 배열 정렬
    public String[] sortArrays(String str) {
        String[] sortArr = str.split("");
        Arrays.sort(sortArr);
        Arrays.sort(sortArr, String.CASE_INSENSITIVE_ORDER);

        return sortArr;
    }
}
