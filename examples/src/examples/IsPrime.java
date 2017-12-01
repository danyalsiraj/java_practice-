package examples;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HackerRank: https://www.hackerrank.com/challenges/prime-checker/problem
 * 
 * @author Danyal
 *
 */
public class IsPrime {
	Map<Integer, Boolean> primeMap = new HashMap<Integer, Boolean>();

	public static void main(String[] args) {
		try {
			// in is a static import of system input stream
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int n1 = Integer.parseInt(br.readLine());
			int n2 = Integer.parseInt(br.readLine());
			int n3 = Integer.parseInt(br.readLine());
			int n4 = Integer.parseInt(br.readLine());
			int n5 = Integer.parseInt(br.readLine());
			IsPrime ob = new IsPrime();
			ob.checkPrime(n1);
			ob.checkPrime(n1, n2);
			ob.checkPrime(n1, n2, n3);
			ob.checkPrime(n1, n2, n3, n4, n5);
			Method[] methods = IsPrime.class.getDeclaredMethods();
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

	public void checkPrime(int... args) {
		// System.out.println(args.length);
		boolean addSpace = false;// could use string buffer too
		for (int i = 0; i < args.length; i++) {
			if (isPrime(args[i])) {
				if (addSpace) {
					System.out.print(" ");
				}
				System.out.print(args[i]);
				addSpace = true;
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
