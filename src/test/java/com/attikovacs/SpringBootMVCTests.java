package com.attikovacs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.attikovacs.SpringBootMVC;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootMVC.class)
@WebAppConfiguration
public class SpringBootMVCTests {

	@Test
	public void contextLoads() {
	}

}
