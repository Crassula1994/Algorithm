package bronze1.num27865;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 최대 질문 횟수를 저장할 변수 maxCount 초기화
	static int maxCount = 20000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 양의 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 질문을 순회
		while (maxCount-- > 0) {
			
			// write() 및 flush() 메서드를 사용해 현재 인터랙터가 가지고 있는 수가 주어진 양의 정수인지 질문
			out.write("? " + number + "\n");
			out.flush();

			// readLine() 메서드를 사용해 질문의 답을 변수 answer에 할당
			String answer = in.readLine();
			
			// 질문의 답이 'Y'인 경우 주어진 양의 정수를 출력 후 반복문 탈출
			if (answer.equals("Y")) {
				out.write("! " + number + "\n");
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}