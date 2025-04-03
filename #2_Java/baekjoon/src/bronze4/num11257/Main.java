package bronze4.num11257;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수험생의 수를 변수 examineeNum에 할당
		int examineeNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 수험생을 순회
		while (examineeNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수험번호와 각 과목에서 받은 점수를 각 변수에 할당
			String examinationNumber = st.nextToken();
			int scoreS = Integer.parseInt(st.nextToken());
			int scoreIM = Integer.parseInt(st.nextToken());
			int scoreT = Integer.parseInt(st.nextToken());
			
			// 세 과목 점수의 합을 계산해 변수 sum에 할당
			int sum = scoreS + scoreIM + scoreT;
			
			// examineeChecekr(), format(), write() 메서드를 사용해 수험번호, 총점, 통과 여부를 출력
			out.write(String.format("%s %d %s\n", examinationNumber, sum, examineeChecker(scoreS, scoreIM, scoreT, sum)));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// examineeChecker() 메서드 정의
	public static String examineeChecker(int scoreS, int scoreIM, int scoreT, int sum) {
		
		// 해당 수험생이 시험을 통과하지 못한 경우 'FAIL' 반환
		if (scoreS < 11 || scoreIM < 8 || scoreT < 12 || sum < 55)
			return "FAIL";
		
		// 해당 수험생이 시험을 통과한 경우 'PASS' 반환
		return "PASS";
	}
}