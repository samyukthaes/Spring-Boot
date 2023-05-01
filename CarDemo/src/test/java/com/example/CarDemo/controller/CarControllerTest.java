package com.example.CarDemo.controller;

import com.example.CarDemo.entity.Car;
import com.example.CarDemo.service.CarService;
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
@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService mockCarService;

    @Test
    void testAddDetails() throws Exception {
        // Setup
        // Configure CarService.addCarDetails(...).
        final Car car = new Car(0, "carName", 0, "brand", "color", 0, "availabilityDate", "status");
        when(mockCarService.addCarDetails(
                new Car(0, "carName", 0, "brand", "color", 0, "availabilityDate", "status"))).thenReturn(car);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sharathcars/cars")
                        .content(asJsonString(car)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Car car) {
        try{
            return new ObjectMapper().writeValueAsString(car);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void testGetDetails() throws Exception {
        // Setup
        // Configure CarService.getAllDetails(...).
        final List<Car> cars = List.of(new Car(0, "carName", 0, "brand", "color", 0, "availabilityDate", "status"));
        when(mockCarService.getAllDetails()).thenReturn(cars);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathcars/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetDetails_CarServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCarService.getAllDetails()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathcars/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetDetailsByDate() throws Exception {
        // Setup
        // Configure CarService.findAllDetailsByDate(...).
        final List<Car> cars = List.of(new Car(0, "carName", 0, "brand", "color", 0, "availabilityDate", "status"));
        when(mockCarService.findAllDetailsByDate("availabilityDate")).thenReturn(cars);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                        get("/sharathcars/{availabilityDate}", "availabilityDate")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetDetailsByDate_CarServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockCarService.findAllDetailsByDate("availabilityDate")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(
                        get("/sharathcars/{availabilityDate}", "availabilityDate")
                                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("[]");
    }
}
