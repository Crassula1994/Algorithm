package bronze2.num22966;

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
		
		// 가장 쉬운 문제의 제목과 난이도를 저장할 각 변수 초기화
		String targetTitle = "";
		int minDifficulty = 5;
		
		// while 반복문을 사용해 각 문제를 순회
		while (questionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제의 제목과 난이도를 각 변수에 할당
			String title = st.nextToken();
			int difficulty = Integer.parseInt(st.nextToken());
			
			// 해당 문제가 현재까지 가장 쉬운 문제인 경우 가장 쉬운 문제의 제목과 난이도를 갱신
			if (minDifficulty > difficulty) {
				minDifficulty = difficulty;
				targetTitle = title;
				
				// 가장 쉬운 난이도의 문제인 경우 반복문 탈출
				if (minDifficulty == 1)
					break;
			}
		}
		
		// write() 메서드를 사용해 가장 쉬운 문제의 제목을 출력
		out.write(targetTitle);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}