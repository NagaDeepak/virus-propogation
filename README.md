# virus-propogation

Virus propogation is used to find out the villages which will be infected when the persons from individual villages start moving from one village to another village.
A grid with 2 dimensional array represents the town where each point in the grid denotes each village.
Application will accept the rest request with request body as json containing information about the grid size, persons position, infected villages.
Based on the infected cells and persons position in the grid, application will return json output denoting initial representation of town and final representation of town with infected villages.

**Sample Input :** 
{
"grid": {"length": 5, "breadth": 5},
"infectedCells": [{"x": 1, "y": 1}, {"x": 2, "y": 3}],
"persons": [

{"initialPosition": "1 0 N", "movement": "FFRFFRF"},
{"initialPosition": "1 3 S","movement": "LFFLFRFRFF"}
]
}

{
"grid": {"length": 3, "breadth": 3},
"infectedCells": [{"x": 0, "y": 0}, {"x": 2, "y": 2}],
"persons": [

{"initialPosition": "0 0 N", "movement": "FFRF"},
{"initialPosition": "1 2 S","movement": "RF"}
]
}

**sample output **

 Inital Villages : 
00000
00100
00000
01000
00000

 Infected Villages after movement : 
00011
00111
01111
01010
00000
