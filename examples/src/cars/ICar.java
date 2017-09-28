package cars;

public interface ICar {
	
	public void accelarate();
	
	public void brake();
	
	public int getSpeed();
	
	
	public default void openSunroof() {
		//do nothing because not all cards have sunroof
	}
}
