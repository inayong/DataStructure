//package 자료구조_ch06;
//
//import java.util.Random;
//import java.util.Scanner;
//
//interface MaxHeap {
//	public void Insert(int x);
//	public int DeleteMax();
//}
//
//class Heap implements MaxHeap {
//	final int heapSize = 100;
//	private int[] heap;
//	private int n; // current size of MaxHeap
//	private int MaxSize; // Maximum allowable size of MaxHeap
//	
//	public Heap(int sz) {
//
//	}
//
//	public void display() {
//
//	}
//	@Override
//	public void Insert(int x) {
//		int i;
//		if (n == MaxSize) { HeapFull(); return; }
//		n++;
//		for (i = n; 1; ) {
//			if (i == 1) break; // at root
//			if (x <= heap[i / 2]) break;
//			// move from parent to i
//			heap[i] = heap[i / 2];
//			i /= 2;
//		}
//		heap[i] = x;
//
//
//	}
//	@Override
//	public int DeleteMax() {
//		int i, j;
//		if (!n) { HeapEmpty(); return 0; }
//		x = heap[1]; Element<Type> k = heap[n]; n--;
//
//		for (i = 1, j = 2; j <= n; )
//		{
//			if (j < n) if (heap[j].key < heap[j + 1].key) j++;
//			// j points to the larger child
//			if (k.key >= heap[j].key) break;
//			heap[i] = heap[j];
//			i = j; j *= 2;
//		}
//		heap[i] = k;
//		return &x;
//	}
//
//	private void HeapEmpty() {
//		System.out.println("Heap Empty");
//	}
//
//	private void HeapFull() {
//		System.out.println("Heap Full");
//	}
//}
//public class Chap6_Test_HeapSort {
//	 static void showData(int[] d) {
//	     for (int i = 0; i < d.length; i++)
//	         System.out.print(d[i] + " ");
//	     System.out.println();
//	 }
//	public static void main(String[] args) {
//		Random rnd = new Random();
//		int select = 0;
//		Scanner stdIn = new Scanner(System.in);
//		Heap heap = new Heap(20);
//	    final int count = 10;
//	    int[] x = new int[count+1];
//	    int []sorted = new int[count];
//
//		do {
//			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
//			select = stdIn.nextInt();
//			switch (select) {
//			case 1:
//				//난수생성
//				x[i] = 난수
//				heap.Insert(x[i]);
//				break;
//			case 2:
//				heap.display();
//				break;
//			case 3:
//				while() {
//					sorted[i] = heap.DeleteMax();
//				}
//				break;
//
//			case 4:
//				return;
//
//			}
//		} while (select < 5);
//
//		return;
//	}
//}
//
