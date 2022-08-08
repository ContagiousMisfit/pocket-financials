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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class InsertFinancialPostingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldInsertFinancialPosting() throws Exception {

        URI uri = new URI("/post/insert");

        JSONObject json = createJsonObject();
        String request = json.toString();

        mockMvc
                .perform(post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

    }

    @Test
    public void shouldReturnBadRequestWhenOneParameterIsMissing() throws Exception {

        URI uri = new URI("/post/insert");

        JSONObject json = createBadRequestJsonObject();
        String request = json.toString();

        mockMvc
                .perform(post(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());

    }

    private JSONObject createJsonObject() throws JSONException {
        return new JSONObject()
                .put("description", "Gift to Chloe")
                .put("value", 120.00)
                .put("userId", 4)
                .put("postingTypeId", 2);
    }

    private JSONObject createBadRequestJsonObject() throws JSONException {
        return new JSONObject()
                .put("value", 120.00)
                .put("userId", 4)
                .put("postingTypeId", 2);
    }
}
