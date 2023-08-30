package 자료구조.ch02;

import java.util.Arrays;
import java.util.Comparator;

public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };
		
		showData(data);
		sortData(data);
		System.out.println();
		showData(data);
	}

	static void showData(String[] arr) {
		for (String str : arr) {
			System.out.print(str + " | ");
		}
	}

	static void swap(String[] arr, int ind1, int ind2) { // [0],[1] 위치바꿔 // data[i].compareTo
		String temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}

	static void sortData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++ ) {
				if (data[i].compareTo(data[j]) > 0) 
					swap(data, i, j);
			}
		}
	}

}
