package com.example.demo.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	Account accountMock;
	@InjectMocks
	AccountController accountControllerUnderTest;

	@Before
	void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(accountControllerUnderTest)
				.build();
	}
	
	@org.junit.Test
	public void  getAllAccountList() throws Exception{
		
		mockMvc.perform(MockMvcRequestBuilders.get("api/v2"))
		.andExpect(MockMvcResultMatchers.status().isOk());
				
	}

	

}
