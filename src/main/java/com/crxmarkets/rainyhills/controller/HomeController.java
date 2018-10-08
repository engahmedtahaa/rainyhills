package com.crxmarkets.rainyhills.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;
/**
 * This Controller Created to redirect to Swagger when you access / 
 * he will redirect to swagger page
 * @author AhmedTaha
 *
 */

@Controller
@ApiIgnore
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}

}

