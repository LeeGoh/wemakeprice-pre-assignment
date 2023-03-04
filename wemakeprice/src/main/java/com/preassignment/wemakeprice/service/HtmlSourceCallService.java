package com.preassignment.wemakeprice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Service
public class HtmlSourceCallService {
    // URI로 HTML Source 데이터 추출
    public String getPageHtmlSourceByUrl(String urlPath) {
        String pageContents = "";
        StringBuilder contents = new StringBuilder();

        try{
            URL url = new URL(urlPath);
            URLConnection con = (URLConnection)url.openConnection();
            InputStreamReader reader = new InputStreamReader (con.getInputStream(), "utf-8");

            BufferedReader buff = new BufferedReader(reader);

            while((pageContents = buff.readLine())!=null){
                contents.append(pageContents);
                contents.append("\r\n");
            }

            buff.close();

        }catch(Exception e){
            e.printStackTrace();
        }

        return contents.toString();
    }
}
