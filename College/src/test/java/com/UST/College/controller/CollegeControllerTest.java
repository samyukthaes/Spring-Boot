package com.UST.College.controller;

import com.UST.College.entity.CollegeInfo;
import com.UST.College.entity.Departments;
import com.UST.College.service.CollegeService;
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
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CollegeController.class)
class CollegeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CollegeService mockCollegeservice;

    @Test
    void testAddCollege() throws Exception {
        // Setup
        // Configure CollegeService.addcollege(...).
        final CollegeInfo collegeInfo = new CollegeInfo(0, "collegeName",
                Set.of(new Departments(0, 0, "departmentName", null)));
        when(mockCollegeservice.addcollege(
                new CollegeInfo(0, "collegeName", Set.of(new Departments(0, 0, "departmentName", null)))))
                .thenReturn(collegeInfo);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/college/add")
                        .content(asJsonString(collegeInfo)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }

    private String asJsonString(CollegeInfo collegeInfo) {
        try{
            return new ObjectMapper().writeValueAsString(collegeInfo);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void testGetCollege() throws Exception {
        // Setup
        // Configure CollegeService.getAllCollege(...).
        final List<CollegeInfo> collegeInfos = List.of(
                new CollegeInfo(0, "collegeName", Set.of(new Departments(0, 0, "departmentName", null))));
        when(mockCollegeservice.getAllCollege()).thenReturn(collegeInfos);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/college/colleges")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetCollege_CollegeServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCollegeservice.getAllCollege()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/college/colleges")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetCollegeById() throws Exception {
        // Setup
        // Configure CollegeService.getCollegeById(...).
        final CollegeInfo collegeInfo = new CollegeInfo(0, "collegeName",
                Set.of(new Departments(0, 0, "departmentName", null)));
        when(mockCollegeservice.getCollegeById(0)).thenReturn(collegeInfo);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/college/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetBycollegeName() throws Exception {
        // Setup
        // Configure CollegeService.getBycollegeName(...).
        final CollegeInfo collegeInfo = new CollegeInfo(0, "collegeName",
                Set.of(new Departments(0, 0, "departmentName", null)));
        when(mockCollegeservice.getBycollegeName("collegeName")).thenReturn(collegeInfo);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/college/find/{collegeName}", "collegeName")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testUpdateCollegeById() throws Exception {
        // Setup
        // Configure CollegeService.updateByCollegeId(...).
        final CollegeInfo collegeInfo = new CollegeInfo(0, "collegeName",
                Set.of(new Departments(0, 0, "departmentName", null)));
        when(mockCollegeservice.updateByCollegeId(
                new CollegeInfo(0, "collegeName", Set.of(new Departments(0, 0, "departmentName", null)))))
                .thenReturn(collegeInfo);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/college/{id}")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDeleteCollege() throws Exception {
        // Setup
        when(mockCollegeservice.deleteCollegeById(0)).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/college/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAddDept() throws Exception {
        // Setup
        // Configure CollegeService.addDepts(...).
        final Departments departments = new Departments(0, 0, "departmentName",
                new CollegeInfo(0, "collegeName", Set.of()));
        when(mockCollegeservice.addDepts(
                new Departments(0, 0, "departmentName", new CollegeInfo(0, "collegeName", Set.of()))))
                .thenReturn(departments);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/college/department")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testAddDepttoClg() throws Exception {
        // Setup
        // Configure CollegeService.addDeptByid(...).
        final CollegeInfo collegeInfo = new CollegeInfo(0, "collegeName",
                Set.of(new Departments(0, 0, "departmentName", null)));
        when(mockCollegeservice.addDeptByid(0)).thenReturn(collegeInfo);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/college/department/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
