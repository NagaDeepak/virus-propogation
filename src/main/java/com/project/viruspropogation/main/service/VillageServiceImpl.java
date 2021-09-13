package com.project.viruspropogation.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.viruspropogation.main.StandardInputObject;
import com.project.viruspropogation.main.entity.Person;
import com.project.viruspropogation.main.factories.PositionFactory;
import com.project.viruspropogation.main.plane.Grid;
import com.project.viruspropogation.main.plane.Movement;
import com.project.viruspropogation.main.plane.PlanePoint;
import com.project.viruspropogation.main.positions.Position;

@Service
public class VillageServiceImpl implements VillageService, Movement {

	private PlanePoint currPlanePoint = null;

	private Position currentPosition = null;

	private int[][] towns;

	private List<Person> persons;

	private Grid villageGrid;

	@Override
	public void setupVillages(StandardInputObject inputObject) {

		this.villageGrid = inputObject.getGrid();
		this.persons = inputObject.getPersons();

		setupGrid(villageGrid);
		plotInfectedCells(inputObject.getInfectedCells(), villageGrid.length);

	}

	public void setupGrid(Grid grid)
	{
		towns = new int[grid.length][grid.breadth];

	}

	public void plotInfectedCells(List<PlanePoint> infectedCells, int gridLength) {
		for(PlanePoint infectedCell : infectedCells)
		{
			//since the input is coming from bottom left corner. Convert the bottom left x and y points to normal 2d array points. 
			int row = (gridLength - 1) - infectedCell.y;
			int column = infectedCell.x;
			towns[row][column] = 1;
		}

	}

	@Override
	public String findInfectedVillages() throws Exception {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\n Inital Village : \n");
		setTownStringFromGrid(stringBuffer);
		
		for(Person person : persons)
		{
			plotPersonOnGrid(person);
			movePerson(person.getMovement());
		}
		stringBuffer.append("\n Infected Villages after movement : \n");
		setTownStringFromGrid(stringBuffer);
		
		return stringBuffer.toString();
	}
	
	public void setTownStringFromGrid(StringBuffer stringBuffer)
	{
		
		for(int i  = 0;i<villageGrid.length;i++)
		{
			for(int j = 0; j<villageGrid.breadth;j++)
			{
				stringBuffer.append(towns[i][j]);
			}
			stringBuffer.append("\n");
		}
	}

	public void movePerson(String movement) throws Exception
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

	public void plotPersonOnGrid(Person person)
	{
		String splits[] = person.getInitialPosition().split("\\s+");

		int x = Integer.parseInt(splits[0]);
		int y = Integer.parseInt(splits[1]);

		int temp = x;
		x  = (villageGrid.length - 1) - y;
		y = temp;
		this.currPlanePoint = new PlanePoint(x, y);

		this.currentPosition = PositionFactory.getPosition(splits[2]);
	}

	@Override
	public void moveForward() throws Exception {
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

	@Override
	public void moveLeft() {
		this.currentPosition = PositionFactory.getPosition(this.currentPosition.getTurnLeftPosition());

	}

	@Override
	public void moveRight() {
		this.currentPosition = PositionFactory.getPosition(this.currentPosition.getTurnRightPosition());

	}

}
