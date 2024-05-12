package com.salesianostriana.dam.proyectoalvarolorentealman;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import com.salesianostriana.dam.proyectoalvarolorentealman.controller.HelloController;


@WebMvcTest(HelloController.class)
class Hellocontrollertest {
	/*test unitario
	 * 
	 * */
	@Autowired
	private MockMvc mvc;
	
	@Test
	void test()throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("index"))
		.andExpect(model().attributeExists("nombre"))
		.andExpect(model().attribute("nombre","Mundo"));
	}

}
