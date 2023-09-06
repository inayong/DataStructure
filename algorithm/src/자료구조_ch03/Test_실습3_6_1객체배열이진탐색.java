package 자료구조_ch03;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	public String toString() { // object에 있는 toString을 이렇게 바꿔서 출력해라
		return "<" + name + ", " + height + ", " + vision + ">";
	}

	@Override
	public int compareTo(PhyscData p) {
		int result = this.name.compareTo(p.name);
		if (result != 0)
			return result;
		int hresult = height - p.height;
		if (hresult != 0)
			return hresult;
		int vresult = (int) (vision - p.vision);
		if (vresult != 0)
			return vresult;
		return 0;
	}
}

public class Test_실습3_6_1객체배열이진탐색 {

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		showData(data);
		sortData(data);
		System.out.println("\n정렬후");
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

	static void showData(PhyscData[] arr) {
		System.out.println();
		for (PhyscData fruit : arr) {
			System.out.print(fruit + " ");
		}
		System.out.println();
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0)
					swap(data, i, j);
			}
		}
	}

	static void swap(PhyscData[] arr, int i, int j) {
		PhyscData temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int linearSearch(PhyscData[] data, PhyscData key) {
		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key) == 0)
				return i;
		}
		return -1;
	}

	static int binarySearch(PhyscData[] data, PhyscData key) {
		int pl = 0;
		int pr = data.length - 1;
		do {
			int pc = (pl + pr) / 2;
			if (data[pc].compareTo(key) == 0)
				return pc;
			else if (data[pc].compareTo(key) < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);
		return -1;
	}

}
