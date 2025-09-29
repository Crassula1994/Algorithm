package bronze2.num06502;

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
		
		// 테스트 케이스의 번호를 저장할 변수 testCaseNum 초기화
		int testCaseNum = 1;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 테스트 케이스를 변수 testCase에 할당
			String testCase = in.readLine();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (testCase.equals("0"))
				break;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(testCase);
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 식탁의 반지름, 피자의 너비와 높이를 각 변수에 할당
			int radius = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("Pizza " + testCaseNum++);
			
			// 피자가 식탁 위에 놓여질 수 없는 경우 'does not fit on the table.'을 출력
			if (width * width + length * length > radius * radius * 4) {
				out.write(" does not fit on the table.");
			
			// 피자가 식탁 위에 놓일 수 있는 경우 'fits on the table.'을 출력
			} else {
				out.write(" fits on the table.");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}