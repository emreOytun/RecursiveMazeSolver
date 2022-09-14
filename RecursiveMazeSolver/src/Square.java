package src;

public class Square {
	private char horizantalName;
	private char verticalName;
	private boolean hasStamp;
	
	public Square() {
		
	}
	
	public Square(Square oth) {
		this.horizantalName = oth.horizantalName;
		this.verticalName = oth.verticalName;
		this.hasStamp = oth.hasStamp;
	}
	
	public Square(char horizantalName, char verticalName) {
		this.hasStamp = false;
		this.horizantalName = horizantalName;
		this.verticalName = verticalName;
	}
		
	public char getHorizantalName() {
		return horizantalName;
	}

	public void setHorizantalName(char horizantalName) {
		this.horizantalName = horizantalName;
	}

	public char getVerticalName() {
		return verticalName;
	}

	public void setVerticalName(char verticalName) {
		this.verticalName = verticalName;
	}

	public String toString() {
		return "" + horizantalName + verticalName;
	}
	
	public boolean hasStamp() {
		return this.hasStamp;
	}
	
	public void putStamp() {
		this.hasStamp = true;
	}
	
}
