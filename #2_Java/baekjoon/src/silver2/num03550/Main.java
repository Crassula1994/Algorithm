package silver2.num03550;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 손상된 보조 질문을 배열 corruptedQuestion에 저장
		char[] corruptedQuestion = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < corruptedQuestion.length; idx++) {
			
			// 해당 글자를 변수 character에 할당
			char character = corruptedQuestion[idx];
			
			// switch 조건문을 사용해 각 글자를 순회
			switch (character) {
				
				// 해당 글자가 괄호인 경우
				case '(':
				case ')':
					
					// write() 메서드를 사용해 '(0)'을 출력
					out.write("(0)");
					
					// 마지막 글자가 아닌 경우 '+'를 출력
					if (idx < corruptedQuestion.length - 1)
						out.write("+");
					
					// 조건문 탈출
					break;
					
				// 해당 글자가 '+'인 경우
				case '+':
					
					// write() 메서드를 사용해 '0+'를 출력
					out.write("0+");
					
					// 마지막 글자인 경우 '0'을 출력
					if (idx == corruptedQuestion.length - 1)
						out.write("0");
					
					// 조건문 탈출
					break;
					
				// 해당 글자가 숫자인 경우
				default:
					
					// write() 메서드를 사용해 해당 숫자를 출력
					out.write(character);
					
					// 마지막 글자가 아닌 경우 '+'를 출력
					if (idx < corruptedQuestion.length - 1)
						out.write("+");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}