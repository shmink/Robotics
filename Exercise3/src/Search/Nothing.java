package Search;

/**
 * Implementation of Nothing
 * (using the "composite pattern").
 */

public class Nothing<A> implements Maybe<A> {
    
  public Nothing() {
  }              

  public boolean isNothing() {
	  return true;
  }

  public int size() {
	  return 0;
  }

  public String toString() {
	  return "Nothing";
  }

  public boolean has(A a) {
	  return false;
  }

  // Higher-order functions:

  public Maybe<A> filter(Predicate<A> p) {
	  return this;
  }

  public <B> Maybe<B> map(Function<A,B> f) {
	  return new Nothing<B>();
  }

  public <B> B fold(Function<A,B> f, B b) {
	  return b;
  }

  public boolean all(Predicate<A> p) {
	  return true;
  }

  public boolean some(Predicate<A> p) {
	  return false;
  }

  public void forEach(Action<A> f) {
  }

  // Unsafe operations:
  public A fromMaybe() {
	  throw new RuntimeException("Unsafe operation!");
  }
}