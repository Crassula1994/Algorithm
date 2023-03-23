package silver3.num01021;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 큐의 크기 및 뽑아내려는 수의 개수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int targetCnt = Integer.parseInt(st.nextToken());

		// 각 정수를 저장할 LinkedList 객체 circularQueue 초기화
		LinkedList<Integer> circularQueue = new LinkedList<>();
		
		// for 반복문을 사용해 circularQueue에 각 정수를 차례로 추가
		for (int number = 1; number <= size; number++)
			circularQueue.offerLast(number);
		
		// 연산의 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int t = 0; t < targetCnt; t++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 targetNum에 할당
			int targetNum = Integer.parseInt(st.nextToken());
			
			// indexOf() 메서드를 사용해 targetNum의 인덱스를 변수 targetIdx에 할당
			int targetIdx = circularQueue.indexOf(targetNum);
			
			// 왼쪽으로 한 칸 이동하는 연산을 사용하는 것이 더 가까운 경우
			if (targetIdx <= circularQueue.size() / 2) {
				
				// while 반복문을 사용해 목표로 하는 값이 나올 때까지 순회
				while (circularQueue.peekFirst() != targetNum) {
					
					// pollFirst() 및 offerLast() 메서드를 사용해 왼쪽으로 한 칸 이동하는 연산 수행
					circularQueue.offerLast(circularQueue.pollFirst());
					
					// 연산의 횟수를 갱신
					count++;
				}
			
			// 오른쪽으로 한 칸 이동하는 연산을 사용하는 것이 더 가까운 경우
			} else {
				
				// while 반복문을 사용해 목표로 하는 값이 나올 때까지 순회
				while (circularQueue.peekFirst() != targetNum) {
					
					// pollLast() 및 offerFirst() 메서드를 사용해 오른쪽으로 한 칸 이동하는 연산 수행
					circularQueue.offerFirst(circularQueue.pollLast());
					
					// 연산의 횟수를 갱신
					count++;
				}
			}
			
			// pollFirst() 메서드를 사용해 목표로 하던 값을 찾아 제거
			circularQueue.pollFirst();
		}

		// valueOf() 및 write() 메서드를 사용해 연산의 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}