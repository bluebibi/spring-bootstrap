package com.thinkonweb.tiis;

import com.thinkonweb.tiis.mapper.ManuscriptMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TiisApplication.class, MybatisConfiguration.class})
@ActiveProfiles("dev")
@WebAppConfiguration
public class TiisApplicationTests {
	private MockMvc mockMvc;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Autowired
	protected WebApplicationContext wac;

	@Autowired
	private ManuscriptMapper manuscriptMapper;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void contextLoads() throws Exception {
		System.out.println(url);
		System.out.println(username);
	}

	@Test
	public void mvcTest() throws Exception {
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("greeting"));
	}

	@Test
	public void mapperTest() {
		assertNotEquals(manuscriptMapper, null);
		System.out.println(manuscriptMapper.test());
	}
}
