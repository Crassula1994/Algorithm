package silver3.num1966;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문서의 개수 및 목표 문서를 각 변수에 할당
			int docNum = Integer.parseInt(st.nextToken());
			int targetDoc = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// 각 문서의 인쇄 순서를 담을 Queue 객체 printQueue 초기화
			Queue<int[]> printQueue = new LinkedList<>();

			// 해당 문서가 출력된 순서를 저장할 변수 order 초기화
			int order = 0;
			
			// for 반복문을 사용해 각 문서의 중요도를 순회
			for (int idx = 0; idx < docNum; idx++) {

				// 해당 문서의 초기 위치와 중요도를 담은 배열 document 초기화
				int[] document = {idx, Integer.parseInt(st.nextToken())};
				
				// offer() 메서드를 사용해 입력 배열 document를 printQueue에 저장
				printQueue.offer(document);
			}
			
			// while 반복문을 사용해 해당 문서가 출력될 때까지 순회
			while (true) {
				
				// iterator() 메서드를 사용해 Iterator 객체를 priorityChecker 변수에 할당
				Iterator<int[]> priorityChecker = printQueue.iterator();
				
				// 현재 최대 중요도 및 해당 인덱스를 저장할 각 변수 초기화
				int topPriority = 0;
				int topIdx = -1;
				
				// 현재 순회 중인 인덱스를 저장할 변수 index 초기화
				int index = -1;
				
				// while 반복문을 사용해 printQueue의 각 원소를 차례로 순회
				while (priorityChecker.hasNext()) {
				
					// 현재 순회 중인 인덱스 갱신
					index++;
					
					// next() 메서드를 사용해 해당 원소의 값을 배열 document에 할당
					int[] document = priorityChecker.next();
					
					// 중요도가 현재 최대 중요도보다 높은 경우 최대 중요도 갱신
					if (document[1] > topPriority) {
						topPriority = document[1];
						topIdx = index;
					}
				}
				
				// for 반복문을 사용해 최대 중요도를 지닌 값의 전까지 순회
				for (int idx = 0; idx < topIdx; idx++)
					
					// poll() 및 offer() 메서드를 사용해 우선순위가 낮은 문서를 뒤로 재배치
					printQueue.offer(printQueue.poll());
	
				// poll() 메서드를 사용해 가장 우선순위가 높은 문서를 뽑아 변수 printedDoc에 할당
				int[] printedDoc = printQueue.poll();
				
				// 문서가 출력된 순서 갱신
				order++;
				
				// 목표로 하던 문서가 출력된 경우 반복문 탈출
				if (printedDoc[0] == targetDoc)
					break;
			}
			
			// write() 메서드를 사용해 해당 문서의 출력 순서 출력
			out.write(order + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}