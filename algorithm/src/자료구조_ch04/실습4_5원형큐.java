package 자료구조_ch04;

import java.util.Random;

/*
 * 원형 큐로서 큐에 Item 객체를 저장 - 교재 소스코드를 원형 큐가 되도록 수정하는 연습
 *   - 원형 큐를 어려워 한다 
 * 원형 큐 실습보다는 객체들의 큐를 ArrayList로 구현하는 실습이 더 유용
 */

import java.util.Scanner;

import 자료구조_ch04.objectQueue.EmptyQueueException;
import 자료구조_ch04.objectQueue.OverflowQueueException;

class Item {
	int data;

	public Item(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return " < " + this.data + " > ";
	}
}
public class 실습4_5원형큐 {

	static final int QUEUE_SIZE = 4; // 크기?
	Item[] circleQueue; //큐용 배열
	int front, rear; //처음, 끝
	static boolean isEmpty; // true or false
	int num;

	//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}
	
	//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}
	
	//--- 생성자(constructor) ---//
	public 실습4_5원형큐() {
		//구현
		num = front = rear = 0;
		circleQueue = new Item[QUEUE_SIZE];					
	}
	
	void push(Item data) throws OverflowQueueException {
		//구현
		System.out.println("num = " + num);
		if (num >= QUEUE_SIZE)
			throw new OverflowQueueException();
		circleQueue[rear++] = data;
		num++;
		if (rear == QUEUE_SIZE)
			rear = 0;
				
	}

	Item pop() throws EmptyQueueException {
		//구현
		if (num <= 0)
			throw new EmptyQueueException();
		Item data = circleQueue[front++];
		num--;
		if (front == QUEUE_SIZE)
			front = 0;
		return data; 
	}

	 void clear() {
			//구현
		num = front = rear = 0;
	}

	 void print() {
			//구현
		 if (num <= 0)
			 System.out.println("큐가 비어 있습니다.");
		 else {
			 for (int i = 0; i < num; i++)
				 System.out.print(circleQueue[(i + front) % QUEUE_SIZE] + " ");
				System.out.println();
		 }
	}
	 
	 boolean isEmpty() {
		 return front == rear;
	 }
	 
	 boolean isFull() {
		 return (rear+1) % QUEUE_SIZE == front;
	 }

	public static void main(String[] args) {
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		int pick;
		실습4_5원형큐 cq = new 실습4_5원형큐();
		while(true) {

			System.out.println("1. Push   2. Pop   3. Clear   4. Print");
			System.out.print("명령을 선택해주세요. => ");
			pick = sc.nextInt();
			Item result = null;
			switch(pick){
			case 1: 
				int num = rnd.nextInt(20); 
				result = new Item(num);
				try {
					cq.push(result);
				} catch(실습4_5원형큐.OverflowQueueException e) {//클래스이름(생성자)
					System.out.println("가득차있습니다.");
				}
				break;
			case 2:
				result= cq.pop();
				System.out.println("pop: result = " + result);
				break;
			case 3: cq.clear(); break;
			case 4: cq.print(); break;
			default: continue;
			}
		}

	}
}
