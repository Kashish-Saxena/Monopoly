package Monopoly;
public abstract class Square {
	String name;
	int position;
	Property property;
	
	public Square(int position) {
		this.position = position;
	}
	
	public int getPosition() {
		return position;
	}
	
}