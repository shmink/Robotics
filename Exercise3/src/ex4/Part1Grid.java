package ex4;
import lejos.geom.Line;
import lejos.geom.Point;
import lejos.robotics.navigation.Pose;
import rp.robotics.mapping.IGridMap;
import rp.robotics.mapping.RPLineMap;

public class Part1Grid implements IGridMap{

	RPLineMap lineMap;
	int gridXSize;
	int gridYSize;
	float xStart;
	float yStart;
	float cellSize;
	
	public Part1Grid(int _gridXSize,
			int _gridYSize, float _xStart, float _yStart, float _cellSize,RPLineMap _lineMap){
		lineMap =_lineMap;
		gridXSize = _gridXSize;
		gridYSize = _gridYSize;
		xStart = _xStart;
		yStart = _yStart;
		cellSize=_cellSize;
		
	}
	
	@Override
	public int getXSize() {
		return gridXSize;
	}

	@Override
	public int getYSize() {
		return gridYSize;
	}

	@Override
	public boolean isValidGridPosition(int _x, int _y) {
		return ( (_x > 0 && _x < gridXSize) 
				&&
				 (_y > 0 && _y < gridYSize) );
	}

	@Override
	public boolean isObstructed(int _x, int _y) {
		Point p = this.getCoordinatesOfGridPosition(_x, _y);
		return !lineMap.inside(p);
	}

	@Override
	public Point getCoordinatesOfGridPosition(int _x, int _y) {
		return new Point((this.xStart + _x * this.cellSize),
							(this.yStart + _y * this.cellSize) );
	}

	@Override
	public boolean isValidTransition(int _x1, int _y1, int _x2, int _y2) {
		///convert x and y to line map points
		//draw direct line between start and finish points
		//loop through all obstacles and check for intersection
		float xStarting = _x1 * this.cellSize + xStart;
		float yStarting = _y1 * this.cellSize + yStart;
		float xEnd = _x2 * this.cellSize + xStart;
		float yEnd = _y2 * this.cellSize + yStart;
	
		Line line = new Line(xStarting,yStarting,xEnd,yEnd);
		
		for (Line l : lineMap.getLines()){
			if(lineMap.intersectsAt(line, l) != null){
				return false;
			}
		}
		return true;
	}

	@Override
		public float rangeToObstacleFromGridPosition(int _x, int _y, float _heading) {
			return this.lineMap.range(new Pose(this.xStart+_x*this.cellSize,this.yStart+_y*this.cellSize,_heading));
		}
	
}
