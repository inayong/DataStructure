package 자료구조_ch03;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;


public class Test_실습3_4정수배열이진탐색 {
	static void inputData(int[] data) { // 클래스의 객체를 따로 생성하지않고도 불러낼수있도록 하기위해서 static사용
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i]= rand.nextInt(10);
		}
	}

	static int linearSearch(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key)
				return i;
		}
		return -1; 
		
	}

	static int binarySearch(int [] a, int key) {
		int pl = 0;
		int pr = a.length -1;
		do {
			int pc = (pl + pr) / 2; //중앙 요소의 인덱스
			if (a[pc] == key)
				return pc; //검색 성공
			else if (a[pc] < key)
				pl = pc + 1; //검색 범위를 뒤쪽 절반으로 좁힘
			else
				pr = pc - 1; //검색 범위를 앞쪽 절반으로 좁힘
		} while (pl <= pr);
		
		return -1;
	}

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data); //구현
		showData(data); //구현
		System.out.println();
//		Arrays.sort(data);
		sortData(data); //구현
		System.out.println("\n정렬후");
		
		for (int num : data) {
			System.out.print(num + " ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println();
		System.out.println("\nlinearSearch(): result = " + result);

		key = 3;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		
		int idx = Arrays.binarySearch(data, key);
//		Arrays.binarySearch(data, key)
		System.out.println("\nArrays.binarySearch(): result = " + result);

	}
	
	static void showData(int[] data) {
		for (int p2 : data) {
			System.out.print(p2 + " ");
		}
	}
	
	static void sortData(int []data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++ ) {
				if (data[i] > data[j]) 
					swap(data, i, j);
			}
		}
	}
	
	static void swap(int[]arr, int ind1, int ind2) {
		int temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	

}
