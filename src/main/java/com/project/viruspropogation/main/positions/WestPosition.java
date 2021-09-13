package com.project.viruspropogation.main.positions;

import com.project.viruspropogation.main.plane.PlanePoint;

public class WestPosition implements Position {

	@Override
	public void moveForward(PlanePoint position) {
		position.y++;
	}

	@Override
	public StandingPositions getTurnLeftPosition() {
		return StandingPositions.north;
	}

	@Override
	public StandingPositions getTurnRightPosition() {
		return StandingPositions.south;
	}

}
