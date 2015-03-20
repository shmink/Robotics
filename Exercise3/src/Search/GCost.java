package Search;

import ex4.Part1Grid;

/*
 * Class used to work out the G-Cost or from getting from one node to another
 */
public class GCost implements Function<Node<Coordinate>, Integer>{
	
	Graph Part1Grid;
	Node<Coordinate> start;
	
	public GCost(Graph Part1Graph, Node<Coordinate> start)
	{
		this.Part1Grid = Part1Grid;
		this.start = start;
	}

	@Override
	public Integer apply(Node<Coordinate> a) {
		if(a.contentsEquals(start.contents()))
		{
			return 0;
		}
		return Part1Grid.reconstructPath(Part1Grid.getPathMap(), start, a.getParent().fromMaybe()).fromMaybe().size();
	}
}