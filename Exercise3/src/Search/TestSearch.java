package Search;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ex4.Part1Grid;
import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;
import rp.robotics.visualisation.GridMapViewer;
import Search.CheckIfGoal;
import Search.Coordinate;
import Search.FunctionTotal;
import Search.IList;
import Search.Maybe;
import Search.Nil;
import Search.Node;
import Search.PriorityQueue;


public class TestSearch 
{
	Part1Grid grid;
	private Search.Graph graph;
	private IList<Coordinate> startNodes;
	private IList<Coordinate> goalNodes;
	
	@BeforeClass
	public void beforeClass()
	{
		RPLineMap lineMap = MapUtils.create2015Map1();
		grid = (Part1Grid)GridMapViewer.createGridMap(lineMap, 10, 7, 14, 31, 30);
		this.graph = new Search.Graph(grid);
		
		//Start
		this.startNodes = new Nil<Coordinate>();
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(0,0), this.startNodes);
	/*	this.startNodes = new Search.Cons<Coordinate>(new Coordinate(1,0), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(2,0), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(3,0), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(1,2), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(2,2), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(2,5), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(2,7), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(3,4), this.startNodes);
		this.startNodes = new Search.Cons<Coordinate>(new Coordinate(4,1), this.startNodes);	*/
		
		///Goal
		this.goalNodes = new Nil<Coordinate>();
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,0), this.goalNodes);
	/*	this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,2), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,3), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,4), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,5), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(3,6), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(4,2), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(5,2), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(6,2), this.goalNodes);
		this.goalNodes = new Search.Cons<Coordinate>(new Coordinate(7,2), this.goalNodes);*/
	}
	
	@Test
	public void Testin()
	{
		for(int j = 0; j < startNodes.size(); j ++)
		{
			 FunctionTotal funcTotal = new FunctionTotal(graph, graph.nodeWith(this.startNodes.head()),
					 graph.nodeWith(this.goalNodes.head()));
			 
			 Node<Coordinate> startNode = graph.nodeWith(this.startNodes.head());
			 Node<Coordinate> goalNode = graph.nodeWith(this.goalNodes.head());
	
			IList<Node<Coordinate>> path =  graph.findPath(graph.nodeWith(this.startNodes.head()), (a->a.getX()==this.goalNodes.head().getX() && a.getY()==this.goalNodes.head().getY()),
					 new PriorityQueue<Node<Coordinate>, Integer>(funcTotal)).fromMaybe();
			 
			Assert.assertEquals(path.head(), startNode);
			Assert.assertEquals(path.reverse().head(), goalNode);
			for(int i = 0; i < path.size()-2; i++)
			{
				Assert.assertEquals(grid.isValidTransition(path.head().contents().getX(),path.head().contents().getY(),
						path.tail().head().contents().getX(), path.tail().head().contents().getY()),true);
				path = path.tail();
			}
			
			this.startNodes = startNodes.tail();
			this.goalNodes = goalNodes.tail();
		}
		
		 //graph.findPath(graph.nodeWith(new Coordinate(0,0)), (a->a.getX()==3 && a.getY()==1), new Stack<Node<Coordinate>>()));

		 
		 //System.out.println(path);
	}
}	
