package 자료구조_ch06;


import 자료구조_ch06.Stack3;
import java.util.Arrays;
import java.util.List;


//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}

//stack코드 가져와서 해야함
public class Chap6_Test_QuickSort {

//퀵 정렬(비재귀 버전)

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack3 st = new Stack3(10);
//		Stack3 st = new Stack3(10);
		Point pt = new Point(left, right);
		st.push(pt);
		// 코드 추가 완성
		
		while (st.isEmpty() != true) {
			Point p = st.pop();
			int pl = left = p.getX();
			int pr = right = p.getY();
			int x = a[(left + right) / 2];
			
			do {
				while (a[pl] < x) pl++;
				while (a[pr] > x) pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
			
			if (p.getX() < pr) {
				st.push(new Point(p.getX(), pr));
			}
			if (pl < p.getY()) {
				st.push(new Point(pl, p.getY()));
			}
		}
		

	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
