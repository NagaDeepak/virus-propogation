package com.project.viruspropogation.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.viruspropogation.main.StandardInputObject;
import com.project.viruspropogation.main.service.VillageService;

@RestController
public class VillageController {

	@Autowired
	private VillageService villageService;
	
	@GetMapping("")
	public String setupGrid(@RequestBody StandardInputObject standardInputObject) throws Exception
	{
		villageService.setupVillages(standardInputObject);
		StringBuffer stringBuffer = new StringBuffer();
		return villageService.findInfectedVillages();
	}
}
