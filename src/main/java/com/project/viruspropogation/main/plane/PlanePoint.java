package com.project.viruspropogation.main.plane;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlanePoint {

	public int x;
	public int y;
	
	@JsonIgnore
	public boolean isInfected;

	public PlanePoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public PlanePoint() {
	}

	@Override
	public String toString() {
		return "PlanePoint [x=" + x + ", y=" + y + ", isInfected=" + isInfected + "]";
	}
	
	
	
	
}
