package Search;

public class CheckIfGoal implements Predicate<Coordinate>
{

	private Coordinate goal;
	
	public CheckIfGoal(Coordinate goal)
	{
		this.goal = goal;
	}

	@Override
	public boolean holds(Coordinate a) {
		// TODO Auto-generated method stub
		return this.goal.equals(a);
	}

}
