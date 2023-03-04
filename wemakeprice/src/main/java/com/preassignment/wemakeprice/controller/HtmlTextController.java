package com.preassignment.wemakeprice.controller;

import com.preassignment.wemakeprice.service.HtmlTextService;
import com.preassignment.wemakeprice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class HtmlTextController {
    private final HtmlTextService htmlTextService;

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @PostMapping("/html-form")
    public String htmlForm(HttpServletRequest request) {
        String url = request.getParameter("url");
        String type = request.getParameter("type");
        Integer num = Integer.parseInt(request.getParameter("num"));

        ResponseDto response = htmlTextService.getQuotientAndRemainder(url, type, num);
        return "index";
    }
}
