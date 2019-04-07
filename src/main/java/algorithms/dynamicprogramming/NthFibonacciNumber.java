package algorithms.dynamicprogramming;

import java.util.Scanner;

public class NthFibonacciNumber {

  //recursive method, not very good
  static int recursiveFib(int n)
  {
    if (n <= 1)
      return n;
    return recursiveFib(n-1) + recursiveFib(n-2);
  }

  //dynamic programming
  static int fib(int n) {
    int[] arr = new int[n+1];
    arr[0] = 0;
    arr[1] = 1;
    for (int i = 2; i <= n; i++) {
      int result = arr[i-2] + arr[i-1];
      arr[i] = result > 1000000007 ? result % 1000000007 : result;
    }
    return arr[n];
  }

  static int optimizedFib(int n) {
    int a = 0, b = 1, c;
    if (n == 0) {
      return n;
    }
    for (int i = 2; i <= n; i++) {
      c = a + b > 1000000007 ? (a + b) % 1000000007 : a + b;
      a = b;
      b = c;
    }
    return b;
  }


  public static void main (String[] args) {
    int nthFibNumber = 20;
    System.out.println(fib(nthFibNumber));

      System.out.println(optimizedFib(nthFibNumber));


  }
}
