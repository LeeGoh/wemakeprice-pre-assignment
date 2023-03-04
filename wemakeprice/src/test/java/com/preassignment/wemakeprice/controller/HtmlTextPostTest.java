package com.preassignment.wemakeprice.controller;


import com.preassignment.wemakeprice.dto.ResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.TestContextBootstrapper;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class HtmlTextPostTest extends HtmlTextControllerTest{

    @Test
    @DisplayName("postFormData")
    void postFormData() throws Exception {
        ResponseDto responseDto = ResponseDto.builder()
                .quotient("Alala7BbZ")
                .remainder("z")
                .build();

        given(htmlTextService.getQuotientAndRemainder
                (Mockito.anyString(), Mockito.anyString(), Mockito.anyInt()))
                .willReturn(responseDto);

        ResultActions actions =
                mockMvc.perform(
                        post("/result")
                                .param("url", url)
                                .param("type", type)
                                .param("unit", unit)
                );

        actions
                .andExpect(status().isOk())
                .andExpect(model().attribute("quotient", "Alala7BbZ"))
                .andExpect(model().attribute("remainder", "z"))
                .andExpect(view().name("index"))
                .andReturn();


    }
}
