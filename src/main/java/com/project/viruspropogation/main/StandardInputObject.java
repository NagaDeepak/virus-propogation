package com.project.viruspropogation.main;


import java.util.List;

import com.project.viruspropogation.main.entity.Person;
import com.project.viruspropogation.main.plane.Grid;
import com.project.viruspropogation.main.plane.PlanePoint;

public class StandardInputObject {

	private Grid grid;
	private List<PlanePoint> infectedCells;
	private List<Person> persons;
	
	public Grid getGrid() {
		return grid;
	}
	public void setGrid(Grid grid) {
		this.grid = grid;
	}
	public List<PlanePoint> getInfectedCells() {
		return infectedCells;
	}
	public void setInfectedCells(List<PlanePoint> infectedCells) {
		this.infectedCells = infectedCells;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public String toString() {
		return "StandardInputObject [grid=" + grid + ", infectedCells=" + infectedCells + ", persons=" + persons + "]";
	}
	
	
	
}
