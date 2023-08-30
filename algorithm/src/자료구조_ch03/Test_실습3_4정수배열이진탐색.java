//package 자료구조_ch03;
//
////3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
////comparator 구현 실습
//import java.util.Arrays;
//
//public class Test_실습3_4정수배열이진탐색 {
//	static void inputData(int[] data) { // 클래스의 객체를 따로 생성하지않고도 불러낼수있도록 하기위해서 static사용
//										// ((Test_실습3_4정수배열이진탐색.inputData)이런식으로 안쓰기 위해서)
//
//	}
//
//	static int linearSearch(int[] data, int key) {
//		for () {
//			
//		}
//		return -1; //int니깐 리턴값 필요
//		
//	}
//
//	static int binarySearch(int [] a, int key) {
//		int pl = 0;
//		int pr = a.length;
//		do {
//			int pc = (pl + pr) / 2;
//			if (a[pc] == key)
//				return pc;
//		}
//	}
//
//	public static void main(String[] args) {
//		int[] data = new int[10];
//		inputData(data); //구현
//		showData(data); //구현
//		Arrays.sort(data);
////		sortData(data); //구현
//		System.out.println();
//		for (int num : data) {
//			System.out.print(num + " ");
//		}
//		int key = 33;
//		int result = linearSearch(data, key);
//		System.out.println("\nlinearSearch(): result = " + result);
//
//		key = 39;
//		result = binarySearch(data, key);
//		System.out.println("\nbinarySearch(): result = " + result);
//		int idx = Arrays.binarySearch(data, key);
////		Arrays.binarySearch(data, key)
//		System.out.println("\nArrays.binarySearch(): result = " + result);
//
//	}
//
//}
