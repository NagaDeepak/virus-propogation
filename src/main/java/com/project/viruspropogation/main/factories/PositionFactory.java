package com.project.viruspropogation.main.factories;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.viruspropogation.main.positions.EastPosition;
import com.project.viruspropogation.main.positions.NorthPosition;
import com.project.viruspropogation.main.positions.Position;
import com.project.viruspropogation.main.positions.SouthPosition;
import com.project.viruspropogation.main.positions.StandingPositions;
import com.project.viruspropogation.main.positions.WestPosition;

public class PositionFactory {

	private static NorthPosition northPosition = new NorthPosition();
	private static EastPosition eastPosition = new EastPosition();
	private static WestPosition westPosition = new WestPosition();
	private static SouthPosition southPosition = new SouthPosition();

	public static Position getPosition(StandingPositions standingPositions)
	{
		switch (standingPositions) {

		case east: return eastPosition; 

		case west : return westPosition; 

		case north : return northPosition; 

		case south : return southPosition; 

		default:
			return null;
		}
	}
	
	public static Position getPosition(String standingPosition)
	{
		switch (standingPosition) {

		case "E": return eastPosition; 

		case "W" : return westPosition; 

		case "N" : return northPosition; 

		case "S" : return southPosition; 

		default:
			return null;
		}
	}

}
