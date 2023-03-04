package com.preassignment.wemakeprice.controller;

import com.preassignment.wemakeprice.service.HtmlTextService;
import com.preassignment.wemakeprice.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class HtmlTextController {
    private final HtmlTextService htmlTextService;

    @GetMapping
    public String getIndex(Model model) {
        return "index";
    }

    @PostMapping("/result")
    public String postFormData(HttpServletRequest request, Model model) {
        String url = request.getParameter("url");
        String type = request.getParameter("type");
        Integer unit = Integer.parseInt(request.getParameter("unit"));

        ResponseDto response = htmlTextService.getQuotientAndRemainder(url, type, unit);
        model.addAttribute("quotient", response.getQuotient());
        model.addAttribute("remainder", response.getRemainder());

        return "index";
    }
}
