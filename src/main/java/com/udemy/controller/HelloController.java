package com.udemy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.bean.Book;

//@Controller
@RestController
@RequestMapping("/v2")
public class HelloController {
	
//	@Autowired
//	private Book book;
	
	@GetMapping("/books")
//	@ResponseBody
	public Map<String, Object> getAll(@RequestParam("page") int page,  
			@RequestParam(value = "qty", defaultValue = "10") int qty) {
		Map<String, String> team1 = new HashMap<String, String>();
		team1.put("title", "NBA");
		team1.put("number", "23");
		team1.put("player", "Lebron James");
		Map<String, String> team2 = new HashMap<String, String>();
		team2.put("title", "NBA");
		team2.put("number", "24");
		team2.put("player", "Kobe Bryant");
		
		List<Map<String, String>> teamList = new ArrayList<Map<String, String>>();
		teamList.add(team1);
		teamList.add(team2);
		
		Map<String, Object> teampMap = new HashMap<String, Object>();
		teampMap.put("page", page);
		teampMap.put("qty", qty);
		teampMap.put("allTeam", teamList);
		return teampMap;
	}
	
	/*
	 * @param id
	 */
//	@GetMapping("/books/{id}")
//	public Book getOneBooks(@PathVariable long id) {
//		return book;
//	}
	
	@GetMapping("/books/{id}")
	public Object getOne(@PathVariable long id) {
		return null;
	}
	
	@PostMapping("/books")
	public Object teamLeader(@RequestParam("name") String name,
			@RequestParam("number") String number,
			@RequestParam("team") String team) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("number", number);
		map.put("team", team);
		
		return map;
	}
}
