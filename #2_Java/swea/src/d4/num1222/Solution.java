package d4.num1222;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < 10; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열 계산식의 길이를 변수 stringLen에 할당
			int stringLen = Integer.parseInt(in.readLine());
			
			// readLine() 메서드를 사용해 입력 받은 중위 표기식을 변수 infixExp에 할당
			String infixExp = in.readLine();
			
			// 후위 표기식으로 변환한 결과를 저장할 변수 postfixExp 초기화
			String postExp = "";
			
			// 연산자를 저장할 Stack 객체 operator 초기화
			Stack<Character> operator = new Stack<>();

			// for 반복문을 사용해 중위 표기식의 각 글자를 순회
			for (int idx = 0; idx < stringLen; idx++) {
				
				// charAt() 메서드를 사용해 중위 표기식의 각 글자를 변수 character에 할당
				char character = infixExp.charAt(idx);
				
				// '+' 연산자인 경우
				if (character == '+') {
					
					
					
				// 피연산자인 경우 후위 표기식에 추가
				} else {
					postExp += character;
				}
				
			}
			
			// write() 메서드를 사용해 최대로 박멸할 수 있는 파리의 수를 출력
			out.write("#" + (tc + 1) + " " + maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}