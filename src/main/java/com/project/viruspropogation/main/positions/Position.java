package com.project.viruspropogation.main.positions;

import com.project.viruspropogation.main.plane.PlanePoint;

public interface Position {
	
	 void moveForward(PlanePoint p);
	 StandingPositions getTurnLeftPosition();
	 StandingPositions getTurnRightPosition();

	 
}
