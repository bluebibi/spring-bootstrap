package com.thinkonweb.tiis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TiisApplication.class, MybatisConfiguration.class})
@ActiveProfiles("dev")
@WebAppConfiguration
public class TiisApplicationTests {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String username;

	@Test
	public void contextLoads() {
		System.out.println(url);
		System.out.println(username);
	}

}
