package bronze4.num10039;

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
		
		// 학생들의 점수 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 원섭, 세희, 상근, 숭이, 강수의 점수를 순회
		for (int i = 0; i < 5; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점수를 변수 score에 할당
			int score = Integer.parseInt(in.readLine());
			
			// max() 메서드를 사용해 점수가 40점 미만인 경우 40점을, 40점 이상인 경우 해당 점수를 합산
			sum += Math.max(score, 40);
		}
			
		// valueOf() 및 write() 메서드를 사용해 5명의 평균 점수를 출력
		out.write(String.valueOf(sum / 5));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}