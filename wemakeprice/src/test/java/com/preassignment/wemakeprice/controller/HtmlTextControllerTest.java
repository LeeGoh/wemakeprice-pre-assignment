package com.preassignment.wemakeprice.controller;

import com.preassignment.wemakeprice.service.CommonService;
import com.preassignment.wemakeprice.service.HtmlSourceCallService;
import com.preassignment.wemakeprice.service.HtmlTextService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@WebMvcTest(controllers = {HtmlTextController.class})
class HtmlTextControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected CommonService commonService;

    @MockBean
    protected HtmlTextService htmlTextService;

    @MockBean
    protected HtmlSourceCallService htmlSourceCallService;

    protected String url;
    protected String type;
    protected String unit;

    @BeforeEach
    void setUp() throws Exception {
        url = "https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com";
        type = "HTML";
        unit = "3";
    }

}