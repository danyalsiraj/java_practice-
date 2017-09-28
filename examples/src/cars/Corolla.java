package cars;

public class Corolla implements ICar {

	int speed = 0;

	public void accelarate() {
		speed += 10;
	}

	public void brake() {
		if (speed > 0)
			speed -= 1;
	}

	public int getSpeed() {
		return speed;
	}
	
	public void jump(){
		//does some jump code
	}
	public void openSunroof() {
		
	}
}
