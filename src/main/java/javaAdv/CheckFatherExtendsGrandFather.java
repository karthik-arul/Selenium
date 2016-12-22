package javaAdv;

public class CheckFatherExtendsGrandFather {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Father f = new Father();
		System.out.println(f.Name);
		f.ootyHouse();
		Grandfather g = new Grandfather();
		g.ootyHouse();
		g.HouseForMyGrandSon();
		f.HouseForMyGrandSon();
	}

}
