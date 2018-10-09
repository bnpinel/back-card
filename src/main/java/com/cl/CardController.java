package com.cl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
	
	@RequestMapping("/advisor")
	public Card getAdvisor(@RequestParam(value="name", defaultValue="toto") String name) {
		return new Card("1", "Albert", "Einstein");
	}

}
