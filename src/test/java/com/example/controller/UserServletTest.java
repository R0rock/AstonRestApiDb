package com.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

class UserServletTest {
    private MockMvc mockMvc;

    @Test
    void testGetUsers() throws Exception {
       this.mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}