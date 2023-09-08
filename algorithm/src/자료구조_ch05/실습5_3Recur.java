package 자료구조_ch05;
//실습 5-3  재귀 알고리즘
//재귀에 대한 이해를 돕는 순수 재귀 메서드

import java.util.Scanner;

class 실습5_3Recur {
//--- 순수 재귀 메서드 ---//
static void recur(int n) {
//   if (n > 0) {
	while (n > 0) {
		if (n > 0 )  {
			s.push(n);
			n = n - 1;
			continue;
		}
		if (s.isEmpty() != true) {
			n = s.pop();
			n = n - 2;
			continue;
		}
  	 System.out.println("recur(" + n + " - 1)");
//       recur(n - 1);
       System.out.println(n);
       System.out.println("recur(" + n + " - 2)");
//       recur(n - 2);
       n = n - 2;
   }
}

public static void main(String[] args) {
   Scanner stdIn = new Scanner(System.in);

   System.out.print("정수를 입력하세요 : ");
   int x = stdIn.nextInt();

   recur(x);
}
}
