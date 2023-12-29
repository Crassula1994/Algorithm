package bronze3.num02506;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제의 개수를 변수 questionNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// 총 점수를 저장할 변수 totalScore 초기화
		int totalScore = 0;
		
		// 각 문제에서 획득한 점수를 저장할 배열 scores 초기화
		int[] scores = new int[questionNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 채점 결과를 순회
		for (int idx = 1; idx <= questionNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 채점 결과를 변수 result에 할당
			int result = Integer.parseInt(st.nextToken());
			
			// 문제를 맞춘 경우 문제에서 획득한 점수와 총 점수를 갱신
			if (result == 1) {
				scores[idx] = scores[idx - 1] + 1;
				totalScore += scores[idx];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 총 점수를 출력
		out.write(String.valueOf(totalScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}