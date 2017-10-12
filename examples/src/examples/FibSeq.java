package examples;

public class FibSeq {

	public static int fibSeq(int n) {

		int nthValue = fibSeq(1, 1, n,0,2);
		return nthValue;
	}

	private static int fibSeq(int first, int second, int n,int nthValue,int counter) {

		if (n==1 || n==2){
			return 1;
		}

		if (counter == n) {
			return nthValue;
		}
		
		nthValue = first + second;
		first = second;
		second = nthValue;
		counter++;
		return fibSeq(first,second,n,nthValue,counter);

	}
	
	//top bottom do same thing, bottom utilizes n to go down instead of having another counter that goes to n
	public static int fibSeq2(int n){
		return fibSeq2(1,1,n);
	}
	
	private static int fibSeq2(int first, int second, int n){
		if (n==1 || n==2){
			return second;
		}
		return fibSeq2(second, first+second, --n);
	}

}
