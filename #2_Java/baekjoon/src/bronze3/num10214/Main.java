package bronze3.num10214;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 각 회에서 연세대와 고려대의 득점을 저장할 각 변수 초기화
			int scoreY = 0;
			int scoreK = 0;
			
			// for 반복문을 사용해 각 회의 득점을 순회
			for (int inning = 1; inning <= 9; inning++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 연세대와 고려대의 득점을 갱신
				scoreY += Integer.parseInt(st.nextToken());
				scoreK += Integer.parseInt(st.nextToken());
			}
			
			// 연세대가 이긴 경우 'Yonsei'를 출력
			if (scoreY > scoreK) {
				out.write("Yonsei");
				
			// 고려대가 이긴 경우 'Korea'를 출력
			} else if (scoreY < scoreK) {
				out.write("Korea");
				
			// 비겼을 경우 'Draw'를 출력
			} else {
				out.write("Draw");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}