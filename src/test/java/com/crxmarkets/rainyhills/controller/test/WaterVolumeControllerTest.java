package com.crxmarkets.rainyhills.controller.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.crxmarkets.rainyhills.RainyHillsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RainyHillsApplication.class)
public class WaterVolumeControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testHomeController() throws Exception {
		ResultMatcher okRedirect = MockMvcResultMatchers.status().is3xxRedirection();

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		this.mockMvc.perform(builder).andExpect(okRedirect);

	}

	@Test
	public void testPostFormPostController() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/WaterVolumeController/get-volumes-number")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content("{\r\n" + "  \"surfaceProfileList\": [\r\n" + "    4, 1, 1, 0, 2, 3\r\n" + "  ]\r\n" + "}");
		this.mockMvc.perform(builder).andExpect(ok);

	}
}