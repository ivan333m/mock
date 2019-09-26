package com.example.demo.rest;

import com.example.demo.config.MockConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import javax.inject.Inject;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockConfiguration.class})
@WebAppConfiguration
public class ModelControllerTest {

    private MockMvc mockMvc;

    @Inject
    private ModelController controller;

//    @Inject
//    private ResponseBuilder responseBuilder;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void findAllModels_invalidRequest_throwNoDataFound() throws Exception {
//        when(responseBuilder.findAll(any())).thenReturn(null);
        mockMvc
        .perform(get("/models"))
            .andExpect(status().is4xxClientError())
            .andExpect(content().string("{\"error\":\"not found\"}"));
    }

}
