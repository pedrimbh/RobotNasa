package model;

public class Robot {

	private int positionX;
	private int positionY;
	private String direction;
	
	public String getPosition() {
		return String.format("(%d,%d,%s)", positionX, positionY, direction);
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
}
