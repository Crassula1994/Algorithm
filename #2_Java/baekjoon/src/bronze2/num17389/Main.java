package bronze2.num17389;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 OX표의 길이와 OX표를 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String tableOX = in.readLine();
		
		// 해당 OX표의 점수를 저장할 변수 totalScore 초기화
		int totalScore = 0;
		
		// for 반복문을 사용해 각 OX표의 결과를 순회
		for (int idx = 0, bonusScore = 0; idx < length; idx++) {
			
			// charAt() 메서드를 사용해 해당 결과를 변수 result에 할당
			char result = tableOX.charAt(idx);
			
			// 문제를 맞힌 경우 기본 점수와 보너스 점수를 획득하고, 보너스 점수를 갱신
			if (result == 'O') {
				totalScore += idx + 1;
				totalScore += bonusScore;
				bonusScore++;
				
			// 문제를 맞히지 못한 경우 보너스 점수를 0으로 초기화
			} else {
				bonusScore = 0;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 OX표의 점수를 출력
		out.write(String.valueOf(totalScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}