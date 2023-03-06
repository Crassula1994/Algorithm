package silver2.num11279;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 연산의 개수를 변수 calcCnt에 할당
		int calcCnt = Integer.parseInt(in.readLine());
		
		// 각 숫자를 저장할 PriorityQueue 객체 maxHeap 초기화
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		// for 반복문을 사용해 각 연산을 순회
		for (int c = 0; c < calcCnt; c++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// '0'을 입력 받은 경우
			if (number == 0) {
				
				// maxHeap에 값이 존재하지 않는 경우 0을 출력 후 다음 연산을 순회
				if (maxHeap.isEmpty()) {
					out.write(0 + "\n");
					continue;
				}
				
				// poll() 및 write() 메서드를 사용해 배열에서 가장 큰 값을 출력
				out.write(maxHeap.poll() + "\n");

			// '0'을 입력 받지 않은 경우 add() 메서드를 사용해 숫자를 maxHeap에 추가
			} else {
				maxHeap.add(number);
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}