package com._daysprojects.day1;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloworldController {
	
	

	@PostMapping("/helloworld")
	 public Map<String, String> postHello(@RequestBody Helloworld helloworld) {
        return Map.of("message", "Welcome to the page browser",
                      "yourMessage", helloworld.getMessage());
    }
	
	@GetMapping("/helloworld")
	public Map<String, String> getHello() {
	    return Map.of("message", "Hello from GET endpoint");
	}

}
