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
	@Override
	public int compareTo(PhyscData2 p)	{
	int result = this.name.compareTo(p.name);
	if (result != 0)
		return result;
	int heightResult = height - p.height;
	if (heightResult != 0)
		return heightResult;
	return heightResult;

}
public class Test_실습2_14객체배열정렬 {

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
	}
	
	static void showData(PhyscData2[] data) {
		for (PhyscData2 p2 : data) {
			System.out.println(p2 + " ");
		}
	}
	
	static void sortData(PhyscData2[] data) {
		
	}


}}


