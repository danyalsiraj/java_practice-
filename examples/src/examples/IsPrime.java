package examples;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsPrime {

	public static void main(String[] args) {
		try {
			// in is a static import of system input stream
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			Prime ob = new Prime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = Prime.class.getDeclaredMethods();
			Set<String> set = new HashSet<>();
			boolean overload = false;
			for (int i = 0; i < methods.length; i++) {
				if (set.contains(methods[i].getName())) {
					overload = true;
					break;
				}
				set.add(methods[i].getName());

			}
			if (overload) {
				throw new Exception("Overloading not allowed");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

class Prime {
	Map<Integer, Boolean> primeMap = new HashMap<Integer, Boolean>();

	public void checkPrime(int... args) {
		// System.out.println(args.length);

		for (int i = 0; i < args.length; i++) {
			if (isPrime(args[i])) {
				System.out.print(args[i] + " ");
			}
		}
		System.out.println();

	}

	private boolean isPrime(int n) {
		boolean isPrime = true;
		if (primeMap.containsKey(n)) {
			return primeMap.get(n);
		}
		if (n < 2) {
			isPrime = false;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					isPrime = false;
				}
			}
		}
		primeMap.put(n, isPrime);
		return isPrime;

	}
}
