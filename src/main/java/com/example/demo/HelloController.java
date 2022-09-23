package com.example.demo;

import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/")
	public String index(Model model) {
		logger.error("XXXXX");
		String sql = "SELECT * FROM sakila.address";
		logger.error(sql);
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		model.addAttribute("testList", list);
		return "index";
	}
}
