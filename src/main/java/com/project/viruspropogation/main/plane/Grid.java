package com.project.viruspropogation.main.plane;

public class Grid {

	public int length;
	public int breadth;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreadth() {
		return breadth;
	}
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}
	public Grid(int length, int breadth) {
		super();
		this.length = length;
		this.breadth = breadth;
	}
	
	public Grid() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Grid [length=" + length + ", breadth=" + breadth + "]";
	}
	
	
	
}
