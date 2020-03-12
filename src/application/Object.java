package application;

public class Object extends GameScreen{
	
	private boolean hasGravity;
	private boolean onFloor;
	
	public Object(boolean hasGravity, boolean onFloor) {
		this.hasGravity = hasGravity;
	}
	
	Object(Object toCopy){
		this.hasGravity = toCopy.hasGravity;
		this.onFloor = toCopy.onFloor;
	}
	
	public boolean getHasGravity() {
		return hasGravity;
	}
	
	public void setHasGravity(boolean bool) {
		this.hasGravity = bool;
	}
	
	public boolean getOnFloor() {
		return onFloor;
	}
	
	public void setOnFloor(boolean bool) {
		this.onFloor = bool;
	}
	
	
	
	
}
