package com.ciandt.cleanarchitechture.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class ListFinancialPostingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldListFinancialPostingsWithDateFilter() throws Exception {
        URI uri = new URI("/post/list");

        JSONObject json = createDateFilterJsonObject();
        String request = json.toString();

        mockMvc.perform(post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.content[0].description").value("Food - Pão de queijo"));
    }

    @Test
    public void shouldListFinancialPostingsWithTypeFilter() throws Exception {
        URI uri = new URI("/post/list");

        JSONObject json = createTypeFilterJsonObject();
        String request = json.toString();

        mockMvc.perform(post(uri)
                        .content(request).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").isNotEmpty())
                .andExpect(jsonPath("$.content[0].description").value("Freelance Job"));

    }

    private JSONObject createDateFilterJsonObject() throws JSONException {
        return new JSONObject()
                .put("startingDate", "2020-03-12")
                .put("endingDate", "2022-08-08");
    }

    private JSONObject createTypeFilterJsonObject() throws JSONException {
        return new JSONObject()
                .put("postingTypeId", "1");
    }
}
