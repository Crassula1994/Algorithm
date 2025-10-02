package bronze4.num25600;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수를 변수 participantNum에 할당
		int participantNum = Integer.parseInt(in.readLine());
		
		// 참가자들이 받은 점수 중에서 가장 높은 점수를 저장할 변수 maxScore 초기화
		int maxScore = 0;
		
		// while 반복문을 사용해 각 참가자를 순회
		while (participantNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 참가자가 얻은 각 점수를 각 변수에 할당
			int scoreA = Integer.parseInt(st.nextToken());
			int scoreD = Integer.parseInt(st.nextToken());
			int scoreG = Integer.parseInt(st.nextToken());
			
			// 해당 참가자가 얻은 점수를 변수 totalScore에 할당
			int totalScore = scoreA * (scoreD + scoreG);
			
			// 해당 참가자가 얻은 점수가 두 배로 계산되는 경우 해당 참가자가 얻은 점수를 갱신
			if (scoreA == scoreD + scoreG)
				totalScore *= 2;
			
			// max() 메서드를 사용해 참가자들이 받은 점수 중에서 가장 높은 점수를 갱신
			maxScore = Math.max(totalScore, maxScore);
		}
		
		// valueOf() 및 write() 메서드를 사용해 참가자들이 받은 점수 중에서 가장 높은 점수를 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}