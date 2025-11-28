package bronze3.num15969;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 가장 높은 점수와 낮은 점수를 저장할 각 변수 초기화
		int minScore = Integer.MAX_VALUE;
		int maxScore = Integer.MIN_VALUE;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 학생의 점수를 순회
		for (int s = 0; s < studentNum; s++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 점수를 변수 score에 할당
			int score = Integer.parseInt(st.nextToken());
			
			// min() 및 max() 메서드를 사용해 가장 낮은 점수와 가장 높은 점수를 갱신
			minScore = Math.min(score, minScore);
			maxScore = Math.max(score, maxScore);
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 높은 점수와 가장 낮은 점수의 차이를 출력
		out.write(String.valueOf(maxScore - minScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}