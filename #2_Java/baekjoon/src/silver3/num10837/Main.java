package silver3.num10837;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임의 라운드 수 및 테스트 케이스의 수를 각 변수에 할당
		int roundNum = Integer.parseInt(in.readLine());
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 영희와 동수의 점수를 각 변수에 할당
			int scoreM = Integer.parseInt(st.nextToken());
			int scoreN = Integer.parseInt(st.nextToken());
			
			// 해당 점수가 나올 수 없는 경우 0을 출력
			if ((scoreM < scoreN && scoreM + roundNum - scoreN < scoreN - 1)
					|| (scoreM > scoreN && scoreM - 1 > scoreN + roundNum - scoreM + 1)) {
				out.write(0 + "\n");
				
			// 해당 점수가 나올 수 있는 경우 1을 출력
			} else {
				out.write(1 + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}