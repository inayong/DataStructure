package 자료구조_ch05;

import java.util.ArrayList;
import java.util.List;

enum Directions2 {N, NE, E, SE, S, SW, W, NW}
class Items3 {
	int x;
	int y;
	int dir;
	public Items3(int x, int y, int d) {
		this.x = x; this.y = y; this.dir = d;
	}
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y + ", dir = " + dir;
	}
}
class Offsets3 {
	int a;
	int b;
	public Offsets3(int a, int b) {
		this.a = a; this.b = b;
	}
}
	class StackList {
	private List<Items3> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // 스택 포인터

	// --- 실행시 예외 : 스택이 비어있음 ---//
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// --- 실행시 예외 : 스택이 가득 참 ---//
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// --- 생성자(constructor) ---//
	public StackList(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<>(0); // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할 수 없음
			capacity = 0;
		}
	}

	// --- 스택에 x를 푸시 ---//
	public void push(Items3 p) throws OverflowIntStackException {
		if (top >= capacity) // 스택이 가득 참
			throw new OverflowIntStackException();
		data.add(p);top++;
		return;
	}

	// --- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
	public Items3 pop() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.remove(--top);
	}

	// --- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
	public Items3 peek() throws EmptyIntStackException {
		if (top <= 0) // 스택이 빔
			throw new EmptyIntStackException();
		return data.get(top - 1);
	}

	// --- 스택을 비움 ---//
	public void clear() {
		top = 0;
	}

	// --- 스택에서 x를 찾아 인덱스(벌견하지 못하면 –1)를 반환 ---//
	public int indexOf(Items3 x) {
		for (int i = top - 1; i >= 0; i--) // 정상 쪽에서 선형검색
			if (data.get(i).equals(x))
				return i; // 검색 성공
		return -1; // 검색 실패
	}

	// --- 스택의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	// --- 스택에 쌓여있는 데이터 갯수를 반환 ---//
	public int size() {
		return top;
	}

	// --- 스택이 비어있는가? ---//
	public boolean isEmpty() {
		return top <= 0;
	}

	// --- 스택이 가득 찼는가? ---//
	public boolean isFull() {
		return top >= capacity;
	}

	// --- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
	public void dump() {
		if (top <= 0)
			System.out.println("스택이 비어있습니다.");
		else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}
}

	public class Chap5_Test_MazingProblem_4회차 {

		static Offsets3[] moves = new Offsets3[8];//static을 선언하는 이유를 알아야 한다

		public static void path(int[][] maze, int[][] mark, int ix, int iy) {

			mark[1][1] = 1; //input을 maze로 바꾸니깐 1,1 시작
			StackList st = new StackList(50);
			Items3 temp = new Items3(0, 0, 0);//N :: 0
			temp.x = 1;
			temp.y = 1; //(1,1) 출발점
			temp.dir = 2;//E:: 2 - 출발시 동쪽으로 이동
			mark[temp.x][temp.y] = 2;//미로 찾기 궤적은 2로 표시 지나온게 2
			st.push(temp);

			while (!st.isEmpty()) // stack not empty
			{
				Items3 tmp = st.pop(); // unstack
				int i = tmp.x;
				int j = tmp.y;
				int d = tmp.dir; //꺼낸거
				mark[i][j] = 0;//backtracking 궤적은 1로 표시 //팝해놓은거
				
				while (d < 8) // moves forward //7까지
				{//구현

					int g =  i + moves[d].a; 
					int h = j + moves[d].b;
					if ((g == ix) && (h == iy)) { // reached exit 출구
													// output path
						mark[i][j] = 2;//출구발견시 현재
						mark[g][h] = 2; //이동위치
						return;
					}
					if ((maze[g][h] == 0) && (mark[g][h] == 0)) { // new position
//						mark[g][h] = 0;
						mark[i][j] = 2; //지나옴
						mark[g][h] = 1; //거쳐간곳을 1로?
						//스택에 넣기, 되돌아가기 d+1, 
						temp = new Items3(g, h, d+1);
						st.push(temp);
						i = g;
						j = h;
						d = 0; //다시 방향탐색
						
//						st.pop();
						
					} else 
						d++;						
					
				}

			}
			
			System.out.println("no path in maze ");
		}
		static void showMatrix(int[][]d, int row, int col) {
			for (int i = 0; i <= row; i++) {
				for (int j = 0; j <= col; j++) {
					System.out.print(d[i][j] + " ");

				}
				System.out.println();
			}
		}
		public static void main(String[] args) {
			int[][] maze = new int[14][17];
			int[][] mark = new int[14][17];

			int input[][] = { // 12 x 15
					{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
					{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
					{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
					{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
					{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
					{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
					{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }};
			for (int ia = 0; ia < 8; ia++)
			moves[ia] = new Offsets3(0, 0);//배열에 offsets 객체를 치환해야 한다.
			moves[0].a = -1;	moves[0].b = 0;
			moves[1].a = -1;	moves[1].b = 1;
			moves[2].a = 0;		moves[2].b = 1;
			moves[3].a = 1;		moves[3].b = 1;
			moves[4].a = 1;		moves[4].b = 0;
			moves[5].a = 1;		moves[5].b = -1;
			moves[6].a = 0;		moves[6].b = -1;
			moves[7].a = -1;	moves[7].b = -1;
			//Directions d;
			//d = Directions.N;
			//d = d + 1;//java는 지원안됨
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 17; j++) {
				//input[12][15] => maze[14][17] (사방을 1로 막음)
					if (i==0 || i== 13 || j==0 || j==16) {
						maze[i][j] = 1;
					}
					else
						maze[i][j] = input[i-1][j-1];

				}
			}
			System.out.println("maze[12,15]::");
			showMatrix(maze, 13, 16);
		
			System.out.println("mark::");
			showMatrix(mark, 13, 16);

			path(maze, mark, 12, 15);//미로찾기 알고리즘 구현 
			System.out.println("mark::");
			showMatrix(mark, 12, 15);
		}
	}

