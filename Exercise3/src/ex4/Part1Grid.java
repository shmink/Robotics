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
			int _gridYSize, float _xStart, float _yStart, float _cellSize,RPLineMap _lineMap)
	{
		gridXSize = _gridXSize;
		gridYSize = _gridYSize;
		xStart = _xStart;
		yStart = _yStart;
		cellSize=_cellSize;
		lineMap =_lineMap;
	}

	@Override
	public int getXSize() {
		return this.gridXSize;
	}

	@Override
	public int getYSize() {
		return this.gridYSize;
	}

	@Override
	public boolean isValidGridPosition(int _x, int _y) {
		return _x<this.gridXSize && _y<this.gridYSize && _x>=0 && _y>=0;

	}

	@Override
	public boolean isObstructed(int _x, int _y) {
		Point p = this.getCoordinatesOfGridPosition(_x, _y);
		return !lineMap.inside(p);
	}

	@Override
	public Point getCoordinatesOfGridPosition(int _x, int _y) {
		return new Point((this.xStart + (_x * this.cellSize)),
				(this.yStart + (_y * this.cellSize)) );
	}

	@Override
	public boolean isValidTransition(int _x1, int _y1, int _x2, int _y2) {
		float xCoord1=this.xStart+_x1*this.cellSize;
		float xCoord2=this.xStart+_x2*this.cellSize;
		float yCoord1=this.yStart+_y1*this.cellSize;
		float yCoord2=this.yStart+_y2*this.cellSize;

		Line line = new Line(xCoord1, yCoord1, xCoord2, yCoord2);
		for(Line l : lineMap.getLines()){
			if (l.intersectsLine(line)) {
				return false;
			}
		}

		if(!this.isObstructed(_x1, _y1) && !this.isObstructed(_x2, _y2) && this.isValidGridPosition(_x1, _y1) && this.isValidGridPosition(_x2, _y2))
		{
			//System.out.println(_x1 + "" + _y1+ " is valid and not obstructed");
			if(_x1==_x2)
			{
				//System.out.println(_x1 + "=" + _x2);
				for(float j=Math.min(yCoord1, yCoord2);j<=Math.max(yCoord1, yCoord2);j++)
				{
					//System.out.println(j);
					if(!this.lineMap.inside(new Point(xCoord1,j))){
						//System.out.println("point " + new Point(xCoord1, j)+ "is not accessible");
						return false;
					}
				}
				//System.out.println("is accessible");
				return true;
			}
			else if(_y1==_y2)
			{
				//System.out.println(_y1 + "=" +_y2);
				{
					for(float j=Math.min(xCoord1, xCoord2);j<=Math.max(xCoord1, xCoord2);j++)
					{
						//System.out.println(j);
						if(!this.lineMap.inside(new Point(j,yCoord1))){
							//System.out.println("point " + new Point(xCoord1, j)+ "is not accessible");
							return false;
						}
					}
				}
				//System.out.println("is accessible");
				return true;
			}
			else return true;
		}
		else return false;
	}

	@Override
	public float rangeToObstacleFromGridPosition(int _x, int _y, float _heading) {
		return this.lineMap.range(new Pose(this.xStart+_x*this.cellSize,this.yStart+_y*this.cellSize,_heading));
	}

}
