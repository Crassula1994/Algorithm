package silver3.num1966;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
			
			(dc1 , dc2) -> {
				return dc1[1] != dc2[1] ? dc2[1] - dc1[1] : dc1[0] - dc2[0];
			}
			
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
				
				// 문서가 출력된 순서 갱신
				order++;
				
				// 목표로 하던 문서가 출력된 경우 반복문 탈출
				if (printQueue.poll()[0] == targetDoc)
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