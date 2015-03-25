package Search;

//import java.util.*;

public class Coordinate {
public int x,y;

public Coordinate(int x, int y) {
  this.x = x;
  this.y = y;
}

@Override
public boolean equals(Object o) {
  Coordinate c = (Coordinate)o;
  return x == c.x && y == c.y;
}

/**
 * gets the value of x
 * @return x - the value of x
 */
public int getX()
{
	  return x;
}

public int hashCode()
{
	return this.getX() + this.getY();
}

/**
 * gets the value of y
 * @return y - the value of y
 */
public int getY()
{
	  return y;
}

/**
 * Makes the readout in the console understandable.
 */
public String toString()
{
	  return x+ ","+y;
}
}
