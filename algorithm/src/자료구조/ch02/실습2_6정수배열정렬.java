package 자료구조.ch02;

import java.util.Arrays;
import java.util.Random;
//교재 60 - 실습 2-6
//2번 실습
public class 실습2_6정수배열정렬 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);

//		/*
		sortData(data);
//		Arrays.sort(data);
		System.out.println();
		showData(data);
//		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		System.out.println();
		showData(data);
		
		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		System.out.println();
		showData(data);
	}
	static void inputData(int []data) {
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data [i] = rnd.nextInt(100);
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
	static void showData(int []data) {
		for (int num: data) {
			System.out.print(num+" ");
		}
	}
//	static void sortData(int []arr) {
//
//	}
	static void reverse(int[] arr) { 
		for (int i = 0; i < arr.length / 2; i++)
			swap(arr, i, arr.length - i - 1);;
		}
						
	
	
	static void reverseSort(int []arr) {
//		for (int i = 0; i < arr.length / 2; i++)
//			swap(arr, i, arr.length - i - 1);
	}

}
