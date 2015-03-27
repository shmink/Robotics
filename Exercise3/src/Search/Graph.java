package Search;

//import Coordinate;
//import Node;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;
import util.SimpleSet;
import ex4.Part1Grid;

//We represent Coordinate graph as Coordinate set of nodes. 
//This is Coordinate minimal class so that Coordinate graph can be created.

public class Graph {
	
	private Map<Node<Coordinate>, Maybe<Node<Coordinate>>> links;
	private Map<Coordinate, Node<Coordinate>> gridNodes;
	private Part1Grid gridMap;   

// Constructs the empty graph:
public Graph(Part1Grid grid) {
	
 // Choose any implementation of sets you please, but you need to
 // choose one.
 gridNodes = new HashMap<Coordinate, Node<Coordinate>>();
 links = new HashMap<Node<Coordinate>, Maybe<Node<Coordinate>>>();
 this.gridMap = grid;
 this.makeGraph();
}

//Convert grid to graph
private void makeGraph()
{
	for(int i = 0; i < gridMap.getXSize(); i++)
	{
		for(int j = 0; j < gridMap.getYSize(); j++)
		{
				Coordinate c = new Coordinate(i,j);
				Node<Coordinate> node = this.nodeWith(c);
			
			//Up
			if(gridMap.isValidTransition(i, j, i, j+1))
			{
				//System.out.println(i + ", " + j + ", "+ i + ", " + (j+1));
				//<Node<Coordinate>,Maybe<Node<Coordinate>>
				//Node<Coordinate> coordinate = new Node<Coordinate>(i, j);
				Node<Coordinate> child = this.nodeWith(new Coordinate(i, j+1));
				node.addSuccessor(child);
			}
			//Down
			if(gridMap.isValidTransition(i, j, i, j-1))
			{
				Node<Coordinate> child = this.nodeWith(new Coordinate(i, j-1));
				node.addSuccessor(child);
				
			}
			//Left
			if(gridMap.isValidTransition(i, j, i-1, j))
			{
				
				Node<Coordinate> child = this.nodeWith(new Coordinate(i-1, j));
				node.addSuccessor(child);
			}
			//Right
			if(gridMap.isValidTransition(i, j, i+1, j))
			{
				Node<Coordinate> child = this.nodeWith(new Coordinate(i+1, j));
				node.addSuccessor(child);
			}
		}
	}
	//for each gridmap coordinate that isn't obstructed
	//add new map entry, coordinate and node coordinate
	//for each of those nodes, look up, right, bottom ,left
	//if isValidTransition, add it as Coordinate successors
	//USE nodeWith
}


public Map<Node<Coordinate>, Maybe<Node<Coordinate>>> getlinks()
{
	  return this.links;
}

// Get method:
public Map<Coordinate, Node<Coordinate>> nodes() 
{
 return this.gridNodes;
}

// Finds or else creates Coordinate node with Coordinate given contents c:
public Node<Coordinate> nodeWith(Coordinate coordinate) 
{
	Node<Coordinate> point;
	if(this.gridNodes.containsKey(coordinate))
		point = gridNodes.get(coordinate);
	else
	{
		point = new Node<Coordinate>(coordinate);
		gridNodes.put(coordinate, point);
	}
 
	return point;
}

// Builds sample graph for testing:
//public static void main(String args []) 
//{    
	//Graph<Coord> robotGraph = new Graph<Coord>();
	

	
 /*int [][] nick = {
   {0,0,1,0,0,1}, 
   {0,1,0,0,1,1,0,2}, 
   {0,2,0,3,0,1}, 
   {0,3,0,2,0,4}, 
   {0,4,0,3,0,5}, 
   {0,5,0,6,1,5,0,4}, 
   {0,6,1,6,0,5}, 
   {1,0,0,0,1,1,2,0}, 
   {1,1,1,2,2,1,1,0,0,1}, 
   {1,2,2,2,1,1,1,3}, 
   {1,3,1,2,1,4,2,3}, 
   {1,4,2,4,1,5,1,3}, 
   {1,5,1,4,2,5,1,6,0,5}, 
   {1,6,0,6,1,5,2,6}, 
   {2,0,3,0,2,1,1,0}, 
   {2,1,2,2,1,1,2,0,3,1}, 
   {2,2,1,2,2,1,2,3,3,2}, 
   {2,3,2,2,2,4,3,3,1,3}, 
   {2,4,1,4,2,5,2,3,3,4}, 
   {2,5,2,4,1,5,2,6,3,5}, 
   {2,6,3,6,2,5,1,6}, 
   {3,0,2,0,3,1}, 
   {3,1,3,0,4,1,2,1,3,2}, 
   {3,2,2,2,4,2,3,1}, 
   {3,3,2,3,3,4}, 
   {3,4,2,4,3,3}, 
   {3,5,3,6,2,5,4,5}, 
   {3,6,2,6,3,5}, 
   {4,0}, 
   {4,1,4,2,5,1,3,1}, 
   {4,2,4,1,5,2,3,2}, 
   {4,3}, 
   {4,4}, 
   {4,5,5,5,3,5}, 
   {4,6}, 
   {5,0}, 
   {5,1,4,1,5,2,6,1}, 
   {5,2,4,2,5,1,6,2}, 
   {5,3}, 
   {5,4}, 
   {5,5,4,5,6,5}, 
   {5,6}, 
   {6,0,7,0,6,1}, 
   {6,1,6,0,5,1,6,2,7,1}, 
   {6,2,5,2,6,1,7,2}, 
   {6,3,7,3,6,4}, 
   {6,4,6,3,7,4}, 
   {6,5,5,5,6,6,7,5}, 
   {6,6,7,6,6,5}, 
   {7,0,6,0,7,1,8,0}, 
   {7,1,8,1,7,0,6,1,7,2}, 
   {7,2,7,3,8,2,6,2,7,1}, 
   {7,3,6,3,7,2,7,4,8,3}, 
   {7,4,7,3,8,4,6,4,7,5}, 
   {7,5,8,5,7,6,7,4,6,5}, 
   {7,6,6,6,7,5,8,6}, 
   {8,0,8,1,7,0,9,0}, 
   {8,1,8,2,9,1,7,1,8,0}, 
   {8,2,8,1,7,2,8,3}, 
   {8,3,8,2,7,3,8,4}, 
   {8,4,8,5,8,3,7,4}, 
   {8,5,9,5,8,4,7,5,8,6}, 
   {8,6,8,5,7,6,9,6}, 
   {9,0,9,1,8,0}, 
   {9,1,8,1,9,2,9,0}, 
   {9,2,9,1,9,3}, 
   {9,3,9,2,9,4}, 
   {9,4,9,5,9,3}, 
   {9,5,8,5,9,4,9,6}, 
   {9,6,9,5,8,6} 
 };

Graph<Coordinate> nicksGraph = new Graph<Coordinate>();
 
 FunctionTotal funcTotal = new FunctionTotal( nicksGraph, nicksGraph.nodeWith(new Coordinate(0,0)), nicksGraph.nodeWith(new Coordinate(3,1)) );

 for (int i = 0; i < nick.length; i++) {
   // What we are going to do relies on the two following facts
   // about nick:
   assert(nick[i].length >= 2);       // (1)
   assert(nick[i].length % 2 == 0);   // (2)

   int x = nick[i][0]; // Can't get array out of bounds 
   int y = nick[i][1]; // because of assertion (1).
   Coordinate c = new Coordinate(x, y);
   Node<Coordinate> node = nicksGraph.nodeWith(c);

   // And next we add its successors. We rely on assertion (2)
   // again to avoid array out of bounds. Now we start from
   // position 2, as positions 0 and 1 have already been looked at
   // (they are x and y). Notice that we need to increment by 2.

   for (int j = 2; j < nick[i].length; j=j+2) {
     int sx = nick[i][j];   
     int sy = nick[i][j+1]; 
     Coordinate sc = new Coordinate(sx, sy);
     Node<Coordinate> s = nicksGraph.nodeWith(sc);
     node.addSuccessor(s);
   }
 }
 // Done. We have the graph. Now we print it back to be sure this worked:
 for (Node<Coordinate> node : nicksGraph.nodes()) {
   System.out.print("(" + node.contents().x + "," + node.contents().y + "): ");
   for(Node<Coordinate> s : node.successors()) {
     System.out.print("(" + s.contents().x + "," + s.contents().y + "), ");
   }
   System.out.println();
 } 
 
 System.out.println("Nodes:");
 
 /*BFS*/
// System.out.println(nicksGraph.findNode(nicksGraph.nodeWith(new Coordinate(4,0)), (Coordinate->Coordinate.getX()==4 && Coordinate.getY()==1), new Queue<Node<Coordinate>>()));
 /*DFS*/
 //System.out.println(nicksGraph.findNode(nicksGraph.nodeWith(new Coordinate(4,0)), (Coordinate->Coordinate.getX()==4 && Coordinate.getY()==1), new Stack<Node<Coordinate>>()));
 /*
 System.out.println("Paths:");
 //Coordinate* Path
 /*DFS Path
 System.out.println(nicksGraph.findPath(nicksGraph.nodeWith(new Coordinate(0,0)), (Coordinate->Coordinate.getX()==3 && Coordinate.getY()==1), new Stack<Node<Coordinate>>()));*/
//}

//Generalization
public Maybe<Node<Coordinate>> findNode(Node<Coordinate> nodeStart, Predicate<Coordinate> pred, DataStructure<Node<Coordinate>> frontier)
{
	  Collection<Node<Coordinate>> visited = new SimpleSet<Node<Coordinate>>();
	  frontier.insertItem(nodeStart);
	  
	  while(!frontier.isEmpty())
	  {
		  if(visited.contains(frontier.getHead().fromMaybe()))
		  {
			  frontier.removeHead();
		  }
		  else if(pred.holds(frontier.getHead().fromMaybe().contents()))
		  {
			  return frontier.getHead();
		  }
		  else
		  {
			  Node<Coordinate> toExpand = frontier.getHead().fromMaybe();
			  visited.add(toExpand);
			  frontier.removeHead();
			  
			  IList<Node<Coordinate>> successors = new Nil<Node<Coordinate>>();
			  for(Node<Coordinate> i : toExpand.successors())
			  {
					successors = successors.append(i);
			  }
			  
			  frontier.insertList(successors);
		  }
	  }
	  return new Nothing<Node<Coordinate>>();
}

//Generalisation
public Maybe<IList<Node<Coordinate>>> findPath(Node<Coordinate> nodeStart, Predicate<Coordinate> pred, DataStructure<Node<Coordinate>> frontier)
{
	  Collection<Node<Coordinate>> visited = new SimpleSet<Node<Coordinate>>();
	  frontier.insertItem(nodeStart);
	  
	  //Hash Map to store our path
	  this.links = new HashMap< Node<Coordinate>, Maybe<Node<Coordinate>> >();
	  
	  while(!frontier.isEmpty())
	  {
		  if(visited.contains(frontier.getHead().fromMaybe()))
		  {
			  frontier.removeHead();
		  }
		  else if(pred.holds(frontier.getHead().fromMaybe().contents()))
		  {
			  Node<Coordinate> goal = frontier.getHead().fromMaybe();
			  links.put(goal,goal.getParent());
			  return reconstructPath(links, nodeStart, goal);
		  }
		  else
		  {
			  Node<Coordinate> toExpand = frontier.getHead().fromMaybe();
			  visited.add(toExpand);
			  frontier.removeHead();
			  
			  for(Node<Coordinate> n : toExpand.successors())
			  {
				  if(!visited.contains(n) && !frontier.checkForDuplicates(n))
				  {
					  n.setParent(new Just<Node<Coordinate>>(toExpand));
				  }
			  }
			  
			  //Gets successors to put in the frontier
			  IList<Node<Coordinate>> successors = new Nil<Node<Coordinate>>();
			  for(Node<Coordinate> i : toExpand.successors())
			  {
					successors = successors.append(i);
			  }
			  
			  links.put(toExpand, toExpand.getParent());		  
			  frontier.insertList(successors);	
		  }
	  }
	  return new Nothing<IList<Node<Coordinate>>>();
}

public Maybe<IList<Node<Coordinate>>> reconstructPath(Map<Node<Coordinate>, Maybe<Node<Coordinate>>> links, Node<Coordinate> nodeStart, Node<Coordinate> goal)
{
		Node<Coordinate> node = goal;
		IList<Node<Coordinate>> path = new Nil<Node<Coordinate>>();
		
		while(!node.contents().equals(nodeStart.contents()))
		{
			path = path.append(node);
			node = links.get(node).fromMaybe();
		}
		
		path = path.append(nodeStart);
		path = path.reverse();

		return new Just<IList<Node<Coordinate>>>(path);
}

public static void main(String [] args)
{
	RPLineMap map = MapUtils.create2015Map1();
	Part1Grid grid = new Part1Grid(12, 8, 15, 15, 30, map);
	Graph graph = new Graph(grid);
	FunctionTotal funcTotal = new FunctionTotal(graph, graph.nodeWith(new Coordinate(0,0)), graph.nodeWith(new Coordinate(9,6)));
	  for (Map.Entry<Coordinate,Node<Coordinate>> node : graph.nodes().entrySet()) {
	      System.out.print(node.getValue() + ": ");
	      for(Node<Coordinate> s : node.getValue().successors()) {
	        System.out.print(s + ", ");
	      }
	      System.out.println();
	    }
	 // graph.findPath(graph.nodeWith(new Coordinate(0,0)), graph.nodeWith(new Coordinate(9,6)), new PriorityQueue<Coordinate,Integer>(funcTotal));
	  IList<Node<Coordinate>> test = graph.findPath(graph.nodeWith(new Coordinate(0,0)), (a->a.getX()==9 && a.getY()==6),
				 new PriorityQueue<Node<Coordinate>, Integer>(funcTotal)).fromMaybe();
	  
	  System.out.println(test);
}

public Map<Node<Coordinate>, Maybe<Node<Coordinate>>> getPathMap() {
	// TODO Auto-generated method stub
	return links;
}
}