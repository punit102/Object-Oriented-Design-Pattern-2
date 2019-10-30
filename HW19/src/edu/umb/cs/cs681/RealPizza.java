package edu.umb.cs.cs681;


public class RealPizza implements Pizza{
	private String realPizza;
	
	public RealPizza(){
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e){}
		System.out.println("A real pizza is made!");
		realPizza = "REAL PIZZA is ready to pickup!";
	}

	public String getPizza(long timeout){
		return realPizza;
	}
}
