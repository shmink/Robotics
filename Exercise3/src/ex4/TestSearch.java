package ex4;

import Search.*;
import util.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import rp.robotics.mapping.IGridMap;
import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;
import rp.robotics.visualisation.GridMapViewer;
import Search.Coordinate;
import Search.IList;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class TestSearch 
{
	IGridMap grid;
	private Graph testGraph;
	private IList<Coordinate> startNode;
	private IList<Coordinate> goalNodes;
	
	@BeforeClass
	public void setUp()
	{
		RPLineMap lineMap = MapUtils.create2015Map1();
		grid = GridMapViewer.createGridMap(lineMap, 10, 7, 14, 31, 30);
		this.testGraph = new Graph(grid);
	}

}