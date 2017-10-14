package examples;

public class PascalTri {
//value at nth row and rth column n!/(r!*(n-r)!)
	
	public static void pascalTri(int nthRow){
		pascalTri(nthRow,0);
	}
	public static void pascalTri(int nthRow, int  row) {
		
		if(row<=nthRow){
			calculateColumnValueInRow(row);
			pascalTri(nthRow, ++row);
		}

	}
	public static void calculateColumnValueInRow(int row){
		for (int i=0;i<=row;i++){
			System.out.print(+factorial(row)/(factorial(i)*factorial(row-i))+" ");
		}
		System.out.println("");

		
	}
	public static void main(String[] args) {
		pascalTri(6);
		//System.out.println(factorial(0));

	}

	public static int factorial(int a) {

		if (a==0){
			return 1;
		}
		if (a > 1) {
			a = a * factorial(--a);	
		}
		return a;
	}
}
