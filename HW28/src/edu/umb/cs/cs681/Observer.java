package edu.umb.cs.cs681;

@FunctionalInterface
public interface Observer {

	void update(Observable obs,Object org);
}
