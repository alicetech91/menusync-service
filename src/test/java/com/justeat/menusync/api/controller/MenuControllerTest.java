package com.justeat.menusync.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justeat.menusync.MenusyncServiceApplication;
import com.justeat.menusync.model.MenuDTO;
import com.justeat.menusync.service.MenuService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
@ContextConfiguration(classes={MenusyncServiceApplication.class})
@Slf4j
public class MenuControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private MenuService menuService;
	
	@Test
	public void testMenuSync() throws Exception {
		
		// assert statements
        assertEquals(0, 0);
        List<MenuDTO> reqDTO = generateRequest();
        List<MenuDTO> resultDTO = new ArrayList<MenuDTO>(); 
        Mockito.when(menuService.menuSync(reqDTO)).thenReturn(resultDTO);
        mvc.perform( MockMvcRequestBuilders
      	      .post("/menu/menuSync")
      	      .content(asJsonString(reqDTO))
      	      .contentType(MediaType.APPLICATION_JSON)
      	      .accept(MediaType.APPLICATION_JSON))
      	      .andExpect(status().isOk());
		
	}
	
	private List<MenuDTO> generateRequest() {
		List<MenuDTO> reqMenu = new ArrayList<MenuDTO>();
		MenuDTO menuDTO = new MenuDTO();
		menuDTO.setCategory("Fast Food");
		menuDTO.setIsAvailable("N");
		menuDTO.setMenuId(100);
		menuDTO.setProductDesc("A hamburger  is a food consisting of one or more cooked patties");
		menuDTO.setProductId("PRD1001");
		menuDTO.setProductName("Humburger");
		menuDTO.setQtyInStock(new Integer(10));
		menuDTO.setSize("Medium");
		menuDTO.setUnitPrice(new BigDecimal(18.00));
		menuDTO.setUom("Euro");
		reqMenu.add(menuDTO);
		return reqMenu;
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	    	log.error("Exception occurred in asJsonString :"+e.getMessage());
	        throw new RuntimeException(e);
	    }
	}

}
