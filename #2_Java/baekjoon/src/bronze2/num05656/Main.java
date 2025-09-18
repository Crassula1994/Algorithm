package bronze2.num05656;

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
		
		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 1;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연산자와 피연산자를 각 변수에 할당
			int leftNumber = Integer.parseInt(st.nextToken());
			String operator = st.nextToken();
			int rightNumber = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (operator.equals("E"))
				break;
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("Case " + testCase++ + ": ");
			
			// switch 조건문을 사용해 주어진 식의 결과를 출력
			switch (operator) {
				case ">":
					out.write((leftNumber > rightNumber) ? "true" : "false");
					break;
				case ">=":
					out.write((leftNumber >= rightNumber) ? "true" : "false");
					break;
				case "<":
					out.write((leftNumber < rightNumber) ? "true" : "false");
					break;
				case "<=":
					out.write((leftNumber <= rightNumber) ? "true" : "false");
					break;
				case "==":
					out.write((leftNumber == rightNumber) ? "true" : "false");
					break;
				default:
					out.write((leftNumber != rightNumber) ? "true" : "false");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}