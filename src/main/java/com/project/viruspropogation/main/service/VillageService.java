package com.project.viruspropogation.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.viruspropogation.main.StandardInputObject;

public interface VillageService {

	void setupVillages(StandardInputObject standardInputObject);
	String findInfectedVillages() throws Exception; 
	
}
