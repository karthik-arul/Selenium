package javaAdv;

public class Lunch {
	
	public void takeLunch(String lunchType){
		System.out.println("Regular Lunch");
	}
	public void takeLunch(String lunchType, int NumBoxes){
		System.out.println("Potluck Lunch");
	}
	public void takeLunch(int Boxes){
		System.out.println("Diet Lunch");
	}
}
