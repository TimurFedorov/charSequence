package com.example.charfrequence;

import com.example.charfrequence.controllers.ConversionController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ConversionController controller;

    @Test
    public void correctRequest() throws Exception {
        this.mockMvc.perform(get("/api/convert?message=aabccc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.length()").value(3) );
    }

    @Test
    public void emptyRequest() throws Exception {
        this.mockMvc.perform(get("/api/convert?message="))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void incorrectRequset() throws Exception {
        this.mockMvc.perform(get("/api/convert?mesge=aaabc"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
