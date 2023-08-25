package 자료구조.ch02;

//메소드에 배열 전달 실습부터
//실습 설명한다 
//페이지 52: 메소드 매개변수로 배열 전달
import java.util.Random;

public class 실습2_5메소드배열전달 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		for (int num: data) {
			System.out.print(num+" ");
		}
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + "존재여부 = " + existValue);
	}
	public static void inputData(int []d) {
		Random rand = new Random();
		for (int i = 0; i < d.length; i++) {
			d[i]= rand.nextInt(10);//교재 56 난수의 생성::보충수업 2-3
		}
	}
	static int findMax(int []items) {
		int max =0;
		for (int item : items) {
			if ( max < item) max = item;
		}
		return max;
	}
	static boolean findValue(int []items, int value) {
		//items[]에 value 값이 있는지를 찾는 알고리즘 구현
		
		return false;
	}

}

