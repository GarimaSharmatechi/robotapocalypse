package com.robotapocalypse.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robotapocalypse.model.Survivor;


@SpringBootTest
@AutoConfigureMockMvc
public class SurvivorControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void createSurvivor() throws Exception 
	{
		Survivor testSurvivor = new Survivor();
		testSurvivor.setName("test1");
		testSurvivor.setGender("male");
		
		mockMvc.perform( MockMvcRequestBuilders
	      .post("/survivors/")
	      .content(asJsonString(testSurvivor))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isCreated());
	}
	
    @Test
    public void getSurvivors() throws Exception {
        this.mockMvc.perform(get("/survivors/"))
                    .andDo(print())
                    .andExpect(status().isOk());
    }
    
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
