package com.chrisbaileydeveloper.bookshelf.controller;

import com.chrisbaileydeveloper.bookshelf.config.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles(Constants.SPRING_PROFILE_DEVELOPMENT)
@WebAppConfiguration
@Transactional
public class SigninControllerTest {
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		SigninController signinController = new SigninController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(signinController).build();
	}

	@Test
	public void testSignin() throws Exception {
		mockMvc.perform(get("/signin"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("signin/signin"));
	}
}
