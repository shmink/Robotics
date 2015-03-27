package ex4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	private IList<Coordinate> startNode;
	private IList<Coordinate> goalNode;
	
	
	@BeforeClass
	public void beforeClass()
	{
		RPLineMap lineMap = MapUtils.create2015Map1();
		grid = (Part1Grid)GridMapViewer.createGridMap(lineMap, 10, 7, 14, 31, 30);
		this.graph = new Search.Graph(grid);
		
		//Start
		this.startNode = new Nil<Coordinate>();
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(0,0), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(1,0), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(2,0), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(3,0), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(1,2), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(2,2), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(2,5), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(2,7), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(3,4), this.startNode);
		this.startNode = new Search.Cons<Coordinate>(new Coordinate(4,1), this.startNode);
		
		///Goal
		this.goalNode = new Nil<Coordinate>();
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,1), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,2), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,3), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,4), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,5), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(3,6), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(4,2), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(5,2), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(6,2), this.goalNode);
		this.goalNode = new Search.Cons<Coordinate>(new Coordinate(7,2), this.goalNode);
	
		
		 FunctionTotal funcTotal = new FunctionTotal(graph, graph.nodeWith(new Coordinate(0,0)),
				 graph.nodeWith(new Coordinate(3,1)));
		 
		 Node<Coordinate> startNode = graph.nodeWith(this.startNode.head());
		 Node<Coordinate> goalNode = graph.nodeWith(this.goalNode.head());

		/* Maybe<IList<Node<Coordinate>>> path =  graph.findPath(graph.nodeWith(new Coordinate(0,0)), (a->a.getX()==3 && a.getY()==1),
				 new PriorityQueue<Node<Coordinate>, Integer>(funcTotal));
		 
		 System.out.println(path);*/
	}
}