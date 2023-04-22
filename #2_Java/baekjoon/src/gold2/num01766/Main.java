package gold2.num01766;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제의 수와 먼저 푸는 것이 좋은 문제에 대한 정보의 개수를 각 변수에 할당
		int questionNum = Integer.parseInt(st.nextToken());
		int infoNum = Integer.parseInt(st.nextToken());
		
		// 각 문제별 먼저 푸는 것이 좋은 문제의 수를 저장할 배열 preQuestion 초기화
		int[] preQuestion = new int[questionNum + 1];
		
		// 각 문제의 풀이 순서에 대한 정보를 저장할 배열 orders 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] orders = new ArrayList[questionNum + 1];
		
		// for 반복문을 사용해 풀이 순서를 저장할 List 객체 초기화
		for (int idx = 0; idx <= questionNum; idx++)
			orders[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 문제 풀이 정보를 순회
		for (int info = 0; info < infoNum; info++) {
		
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 먼저 풀면 좋은 문제 및 나중에 풀면 좋은 문제를 각 변수에 할당
			int prevQuestion = Integer.parseInt(st.nextToken());
			int nextQuestion = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 문제 풀이 순서를 추가
			orders[prevQuestion].add(nextQuestion);
			
			// 문제별 먼저 푸는 것이 좋은 문제의 수를 갱신
			preQuestion[nextQuestion]++;
		}
		
		// 다음에 풀 문제를 저장할 PriorityQueue 객체 solveList 초기화
		PriorityQueue<Integer> solveList = new PriorityQueue<>();
		
		// for 반복문을 사용해 배열 preQuestion의 각 원소를 순회
		for (int idx = 1; idx <= questionNum; idx++) {
			
			// 해당 문제의 먼저 푸는 것이 좋은 문제가 존재하지 않는 경우 solveList에 추가
			if (preQuestion[idx] == 0)
				solveList.offer(idx);
		}
		
		// while 반복문을 사용해 solveList가 빌 때까지 순회
		while (!solveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 풀이 중인 문제를 변수 currentQuestion에 할당
			int currentQuestion = solveList.poll();

			// write() 메서드를 사용해 풀이한 해당 문제를 출력
			out.write(currentQuestion + " ");
			
			// for 반복문을 사용해 현재 풀이 중인 문제가 먼저 푸는 것이 좋은 문제인 문제를 순회
			for (int idx = 0; idx < orders[currentQuestion].size(); idx++) {
				
				// get() 메서드를 사용해 현재 풀이 중인 문제가 먼저 푸는 것이 좋은 문제인 문제를 변수 nextQuestion에 할당
				int nextQuestion = orders[currentQuestion].get(idx);
				
				// 해당 문제의 먼저 푸는 것이 좋은 문제의 수를 갱신
				preQuestion[nextQuestion]--;
				
				// 해당 문제의 먼저 푸는 것이 좋은 문제의 수가 0인 경우 solveList에 추가
				if (preQuestion[nextQuestion] == 0)
					solveList.offer(nextQuestion);
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}