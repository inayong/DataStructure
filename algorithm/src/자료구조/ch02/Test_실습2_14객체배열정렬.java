package 자료구조.ch02;

class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	public String toString() { //object에 있는 toString을 이렇게 바꿔서 출력해라
		return "<"+name + ", " + height + ", " + vision + ">"; 
	}
	@Override
	public int compareTo(PhyscData2 p)	{
	int result = this.name.compareTo(p.name);
	if (result != 0)
		return result;
	int heightResult = height - p.height;
	if (heightResult != 0)
		return heightResult;
	int visionResult =  (int) (vision - p.vision);  //double을 int로
	if (visionResult != 0)
		return visionResult;
	return 0;
	}
}
public class Test_실습2_14객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍길동", 162, 1.3),
				new PhyscData2("홍길동", 152, 0.7),
				new PhyscData2("홍길동", 152, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("이길동", 182, 0.2),
				new PhyscData2("이길동", 169, 0.5),
		};
		showData(data);
		sortData(data);
		System.out.println("\n정렬후");
		showData(data);
	}
	
	static void showData(PhyscData2[] data) {  //p2는 객체
		for (PhyscData2 p2 : data) {
			System.out.println(p2 + " ");
		}
	}
	static void swap(PhyscData2[]arr, int ind1, int ind2) {
		PhyscData2 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	static void sortData(PhyscData2[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++ ) {
				if (data[i].compareTo(data[j]) > 0) //객체비교니깐 .compareTo
					swap(data, i, j);
			}
		}
	}


}


