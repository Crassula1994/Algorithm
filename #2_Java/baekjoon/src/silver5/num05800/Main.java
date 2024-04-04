package silver5.num05800;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 반의 수를 변수 classNum에 할당
		int classNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 반의 정보를 순회
		for (int c = 1; c <= classNum; c++) {
			
			// write() 메서드를 사용해 반의 번호를 출력
			out.write("Class " + c + "\n");
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(st.nextToken());
			
			// 가장 높은 점수, 낮은 점수, 가장 큰 인접한 점수 차이를 저장할 각 변수 초기화
			int maxScore = Integer.MIN_VALUE;
			int minScore = Integer.MAX_VALUE;
			int maxDiff = -1;
			
			// 학생의 성적을 내림차순으로 정렬할 PriorityQueue 객체 scoreRanker 초기화
			PriorityQueue<Integer> scoreRanker = new PriorityQueue<>((s1, s2) -> {
				return s2 - s1;
			});
			
			// for 반복문을 사용해 입력 받은 각 학생의 성적을 순회
			for (int student = 0; student < studentNum; student++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 성적을 변수 score에 할당
				int score = Integer.parseInt(st.nextToken());
				
				// max() 및 min() 메서드를 사용해 가장 높은 점수와 낮은 점수를 갱신
				maxScore = Math.max(score, maxScore);
				minScore = Math.min(score, minScore);
				
				// offer() 메서드를 사용해 학생의 성적을 socreRanker에 추가
				scoreRanker.offer(score);
			}
			
			// poll() 메서드를 사용해 이전 점수를 변수 prevScore 초기화
			int prevScore = scoreRanker.poll();
			
			// while 반복문을 사용해 scoreRanker가 빌 때까지 순회
			while (!scoreRanker.isEmpty()) {
				
				// poll() 메서드를 사용해 이후 점수를 변수 nextScore 초기화
				int nextScore = scoreRanker.poll();
				
				// max() 메서드를 사용해 가장 큰 인접한 점수 차이를 갱신
				maxDiff = Math.max(prevScore - nextScore, maxDiff);
				
				// 이후 점수를 이전 점수로 갱신
				prevScore = nextScore;
			}
			
			// write() 메서드를 사용해 가장 높은 점수, 낮은 점수, 가장 큰 인접한 점수 차이를 출력
			out.write("Max " + maxScore + ", Min " + minScore + ", Largest gap " + maxDiff + "\n");
		} 
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}