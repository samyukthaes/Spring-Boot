package com.UST.Interview.controller;

import com.UST.Interview.entity.Interview;
import com.UST.Interview.service.InterviewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InterviewController.class)
class InterviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InterviewService mockService;

    @Test
    void testAddDetails() throws Exception {
        // Setup
        // Configure InterviewService.addInterviewDetails(...).
        final Interview interview = new Interview(0, "name", "emailid", "phno", "skills", "experience", "intdate",
                "time", "link", "poc");
        when(mockService.addInterviewDetails(
                new Interview(0, "name", "emailid", "phno", "skills", "experience", "intdate", "time", "link",
                        "poc"))).thenReturn(interview);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/add")
                        .content(asJsonString(interview)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Interview interview) {
        try{
            return new ObjectMapper().writeValueAsString(interview);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void testGetDetails() throws Exception {
        // Setup
        // Configure InterviewService.getAllDetails(...).
        final List<Interview> interviews = List.of(
                new Interview(0, "name", "emailid", "phno", "skills", "experience", "intdate", "time", "link", "poc"));
        when(mockService.getAllDetails()).thenReturn(interviews);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/details")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetDetails_InterviewServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockService.getAllDetails()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/details")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetDetailsById() throws Exception {
        // Setup
        // Configure InterviewService.findDetailsById(...).
        final Interview interview = new Interview(0, "name", "emailid", "phno", "skills", "experience", "intdate",
                "time", "link", "poc");
        when(mockService.findDetailsById(0)).thenReturn(interview);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/details/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
