package cars;

import java.util.ArrayList;

public class TestCar {
	
	void speedtest(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Corolla car1 = new Corolla();
		car1.accelarate();
		
		Camry car2 = new Camry();
		car2.accelarate();
		
		ICar car3 = new Corolla();
		ArrayList <ICar> totalCars= new ArrayList <ICar>();
		totalCars.add(new Corolla());
		totalCars.add(new Camry());
		
		for (ICar car:totalCars)
		{
			car.accelarate();
			if(car instanceof Corolla){
				((Corolla)car).jump();
				System.out.println("Corolla speed" + car.getSpeed());
			}
			if(car instanceof Camry){
				System.out.println("Camry speed" + car.getSpeed());
			}
			
		}
		
		
	}

}
