package gold5.num11000;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수업의 개수를 변수 classNum에 할당
		int classNum = Integer.parseInt(in.readLine());

		// 입력 받은 각 수업을 저장할 각 PriorityQueue 객체 fastClass 초기화
		PriorityQueue<int[]> fastClass = new PriorityQueue<>((c1, c2) -> {
			return (c1[0] == c2[0]) ? c1[1] - c2[1] : c1[0] - c2[0];
		});
		
		// 나머지 수업을 저장할 Queue 객체 remainClass 초기화
		Queue<int[]> remainClass = new LinkedList<>();
		
		// for 반복문을 사용해 각 수업을 순회
		for (int c = 0; c < classNum; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수업의 시작 시간과 종료 시간을 배열 time에 저장
			int[] time = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			// offer() 메서드를 사용해 fastClass에 배열 time을 추가
			fastClass.offer(time);
		}
		
		// while 반복문을 사용해 queue가 빌 때까지 순회
		while (!fastClass.isEmpty())
		
		// size번째 큰 수를 저장할 변수와 반복 횟수를 저장할 변수 초기화
		int targetNum = 0;
		int count = 0;
		
		// while 반복문을 사용해 size번째 큰 수가 나올 때까지 순회
		while (count < size) {
			
			// 반복 횟수 갱신
			count++;
			
			// poll() 메서드를 사용해 현재 maxHeap에서 가장 큰 값을 targetNum에 저장
			targetNum = maxHeap.poll();
		}
		
		// valueOf() 및 write() 메서드를 사용해 size번째 큰 수를 출력
		out.write(String.valueOf(targetNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}