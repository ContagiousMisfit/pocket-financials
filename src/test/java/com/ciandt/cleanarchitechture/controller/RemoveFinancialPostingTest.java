package com.ciandt.cleanarchitechture.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class RemoveFinancialPostingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRemoveFinancialPosting() throws Exception {

        URI uri = new URI("/post/remove/3");

        mockMvc
                .perform(patch(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.active").value(false));

    }
}
