package com.thinkonweb.domesticConf;

import com.thinkonweb.domesticConf.service.ConferenceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		{
				"file:src/main/resources/common/spring.xml",
				"file:src/main/resources/common/security.xml",
				"file:src/main/resources/common/mybatis.xml"
		}
)
public class ApplicationTests {
	private MockMvc mockMvc;

	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Inject
	protected WebApplicationContext wac;

	@Value("${prod}")
	private boolean prod;

	@Value("${jdbc.url}")
	private String jdbcUrl;

	@Value("${message}")
	private String message;

	@Inject
	private ConferenceService conferenceService;

	@Inject
	private PasswordEncoder passwordEncoder;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void contextLoads() throws Exception {
		System.out.println(prod);
		System.out.println(message);
	}

	@Test
	public void mvcTest() throws Exception {
		mockMvc.perform(get("/kips2016spring"))
				.andExpect(status().isOk())
				.andExpect(view().name("greeting"));
	}

	@Test
	public void mapperTest() {
		assertNotEquals(conferenceService, null);
		System.out.println(conferenceService.getConferenceByNameId("kips2016spring"));
	}

	@Test
	public void getPassword() {
        System.out.println(passwordEncoder.encode("admin"));
        System.out.println(passwordEncoder.encode("kips2016"));
    }
}