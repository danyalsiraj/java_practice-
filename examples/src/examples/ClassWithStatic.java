package examples;

public class ClassWithStatic {
	
	int age = 0;
	static int age2 =  0;
	
	//no need java does automatically
	
	public ClassWithStatic(){
		super();
	}
	
	public static void main(String[] args){
				
		ClassWithStatic firstObj = new ClassWithStatic();
		firstObj.age++;
		firstObj.age2++;
		
		ClassWithStatic secondObj =  new ClassWithStatic();
		secondObj.age++;
		secondObj.age2++;
		
		
		Object thirdObj =  new ClassWithStatic();
		
		
		
		
		System.out.println(String.format("First age: %s firstObj.age2: %s second age: %s second age2 %s ClassWithStatic.age2=%s",
				firstObj.age,
				firstObj.age2,
				secondObj.age, 
				secondObj.age2, 
				age2));
	}

}
