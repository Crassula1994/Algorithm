package silver3.num02075;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 표의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());

		// 입력 받은 각 값을 저장할 PriorityQueue 객체 maxHeap 초기화
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		// for 반복문을 사용해 표의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 표의 각 열을 순회하며 입력 받은 각 값을 maxHeap에 추가
			for (int c = 0; c < size; c++)
				maxHeap.add(Integer.parseInt(st.nextToken()));
		}
		
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