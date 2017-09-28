package cars;

public class Camry implements ICar{

	int speed = 0;

	public void accelarate() {
		speed += 20;
	}

	public void brake() {
		if (speed > 0)
			speed -= 2;
	}
	public int getSpeed(){
		return speed;
		}
}
