package silver4.num26433;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 빨강 팀과 노랑 팀의 점수를 저장할 각 변수 초기화
			int redScore = 0;
			int yellowScore = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스톤과 하우스의 반지름을 각 변수에 할당
			int radiusStone = Integer.parseInt(st.nextToken());
			int radiusHouse = Integer.parseInt(st.nextToken());
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 빨강 팀의 스톤 개수를 변수 redCount에 할당
			int redCount = Integer.parseInt(in.readLine());
			
			// format() 및 write() 메서드를 사용해 빨강 팀과 노랑 팀의 점수를 출력
			out.write(String.format("Case #%d: %d %d\n", tc, redScore, yellowScore));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}