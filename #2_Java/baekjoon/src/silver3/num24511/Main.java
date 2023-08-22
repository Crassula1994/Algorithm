package silver3.num24511;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자료구조의 개수를 변수 structureNum에 할당
		int structureNum = Integer.parseInt(in.readLine());
		
		// 각 자료구조가 큐인지, 스택인지를 나타내는 배열 isQueue를 초기화
		boolean[] isQueue = new boolean[structureNum];
		
		// 해당 자료구조 중 큐에 저장된 값만 저장할 Deque 객체 queuestack 초기화
		Deque<Integer> queuestack = new ArrayDeque<>();
		
		// StringTokenzier 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 자료구조의 종류를 순회
		for (int idx = 0; idx < structureNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자료구조의 종류를 변수 kind에 할당
			int kind = Integer.parseInt(st.nextToken());
			
			// 해당 자료구조가 큐인 경우 true를 저장
			if (kind == 0)
				isQueue[idx] = true;
		}
		
		// StringTokenzier 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 자료구조에 저장된 숫자를 순회
		for (int idx = 0; idx < structureNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자료구조에 저장된 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// 저장된 자료구조가 큐인 경우 queuestack에 추가
			if (isQueue[idx])
				queuestack.addLast(number);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 삽입할 수열의 길이를 변수 sequenceLen에 할당
		int sequenceLen = Integer.parseInt(in.readLine());
		
		// StringTokenzier 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 삽입할 각 숫자를 순회
		for (int n = 0; n < sequenceLen; n++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 queuestack에 삽입할 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// addFirst() 메서드를 사용해 해당 숫자를 삽입
			queuestack.addFirst(number);
			
			// pollLast() 및 write() 메서드를 사용해 리턴값을 출력
			out.write(queuestack.pollLast() + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}