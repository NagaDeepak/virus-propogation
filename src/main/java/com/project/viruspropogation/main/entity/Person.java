package com.project.viruspropogation.main.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.viruspropogation.main.factories.PositionFactory;
import com.project.viruspropogation.main.plane.PlanePoint;
import com.project.viruspropogation.main.positions.Position;

public class Person {

	private String initialPosition = null;
	private String movement = null;


	public String getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(String initialPosition) {
		this.initialPosition = initialPosition;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String initialMovement) {
		this.movement = initialMovement;
	}


	public Person() {
	}

	@JsonIgnore
	PlanePoint currPlanePoint = null;

	@JsonIgnore
	PlanePoint previousPlanePoint = null;

	@JsonIgnore
	Position currentPosition = null;

	@JsonIgnore
	int[][] towns;



	public Person(String initialPosition, String movement) {
		this.initialPosition = initialPosition;
		this.movement = movement;
	}


	public void setInitialPoints(int length, int breadth)
	{

		String splits[] = initialPosition.split("\\s+");

		int x = Integer.parseInt(splits[0]);
		int y = Integer.parseInt(splits[1]);

		int temp = x;
		x  = (length - 1) - y;
		y = temp;
		this.currPlanePoint = new PlanePoint(x, y);
		
		this.currentPosition = PositionFactory.getPosition(splits[2]);

	}

	public void setTowns(int[][] towns)
	{
		this.towns = towns;
	}

	public void startMoving() throws Exception
	{
		for(int i = 0; i<movement.length(); i++)
		{
			char c= movement.charAt(i);

			switch (c) 
			{
			case 'F':
				moveForward();
				break;

			case 'R': 
				moveRight();
				break;

			case 'L' :
				moveLeft();
				break;
			default:
				throw new IllegalArgumentException("Default supported is L, R, F movements");
			}

		}
	}

	public void moveForward() throws Exception
	{
		int currentHouse =  towns[currPlanePoint.x][currPlanePoint.y];
		if( currentHouse == 1 && !currPlanePoint.isInfected  )
			currPlanePoint.isInfected = true;

		currentPosition.moveForward(currPlanePoint);

		try 
		{
			if(currPlanePoint.isInfected)
				towns[currPlanePoint.x][currPlanePoint.y] = 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new Exception("Person is moving out of the selected towns or grid. Please check input for movement of the person");
		}
		
	}

	public void moveRight() 
	{
		this.currentPosition = PositionFactory.getPosition(this.currentPosition.getTurnRightPosition());
	}

	public void moveLeft() 
	{
		this.currentPosition = PositionFactory.getPosition(this.currentPosition.getTurnLeftPosition());
	}

	public void printHouses() {

		for(int i = 0; i<5;i++)
		{
			for(int j = 0;j <5;j++)
			{
				System.out.print(towns[i][j]);
			}

			System.out.println();
		}

	}

}
