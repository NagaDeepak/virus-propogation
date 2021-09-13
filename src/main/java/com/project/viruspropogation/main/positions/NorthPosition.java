package com.project.viruspropogation.main.positions;

import com.project.viruspropogation.main.plane.PlanePoint;

public class NorthPosition implements Position {

	@Override
	public void moveForward(PlanePoint position) {
		position.x--;
	}

	@Override
	public StandingPositions getTurnLeftPosition() {
		return StandingPositions.east;
	}

	@Override
	public StandingPositions getTurnRightPosition() {
		return StandingPositions.west;
	}

	
}
