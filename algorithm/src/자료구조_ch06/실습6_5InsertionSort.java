package 자료구조_ch06;

//단순 삽입 정렬 - 6.4

import java.util.Scanner;

class 실습6_5InsertionSort {
//--- 단순 삽입 정렬 ---//
static void insertionSort(int[] a, int n) {
	 int count = 0;
   for (int i = 1; i < n; i++) {
       int j;
       int tmp = a[i];
       for (j = i; j > 0 && a[j - 1] > tmp; j--) {
      	 count++;
      	 a[j] = a[j - 1];
       }

       a[j] = tmp;//tmp를 insert한다.
       System.out.println("tmp = " + tmp);
       for (int num : a)
      	 System.out.print(" " + num);
       System.out.println();
   }
   System.out.println("비교횟수 = " + count);
}

public static void main(String[] args) {
   Scanner stdIn = new Scanner(System.in);

   System.out.println("단순 삽입 정렬");
   /*
   System.out.print("요솟수: ");
   int nx = stdIn.nextInt();
   */
   //int[] x = new int[nx];
   int nx = 7;
   int []x = {6,4,1,7,3,9,8};
   /*
   for (int i = 0; i < nx; i++) {
       double d = Math.random();
       x[i] = (int) (d * 100);
   }
   */
   for (int n: x)
  	 System.out.print(" " + n);
   System.out.println();

   insertionSort(x, nx);        // 배열 x를 단순삽입정렬

   System.out.println("오름차순으로 정렬했습니다.");
   for (int i = 0; i < nx; i++)
       System.out.print("  " + x[i]);
}
}
