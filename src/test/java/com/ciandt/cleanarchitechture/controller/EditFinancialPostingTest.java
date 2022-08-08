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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class EditFinancialPostingTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldEditFinancialPosting() throws Exception {

        URI uri = new URI("/post/edit/3");

        JSONObject json = createJsonObject();
        String request = json.toString();

        mockMvc
                .perform(put(uri)
                        .content(request)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());

    }

    private JSONObject createJsonObject() throws JSONException {
        return new JSONObject()
                .put("description", "New Clothes")
                .put("value", 180.00)
                .put("userId", 4)
                .put("postingTypeId", 2);
    }

}
