package com.project.viruspropogation.main.positions;

import com.project.viruspropogation.main.plane.PlanePoint;

public class EastPosition implements Position {

	
	@Override
	public void moveForward(PlanePoint planePoint) {
		planePoint.y--;
	}

	@Override
	public StandingPositions getTurnLeftPosition() {
		return StandingPositions.south;
	}

	@Override
	public StandingPositions getTurnRightPosition() {
		return StandingPositions.north;
	}

	
}
