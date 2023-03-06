package silver3.num17413;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 괄호 내부의 문자임을 알려주는 변수 isInside 초기화
		boolean isInside = false;

		// 거꾸로 출력할 내용을 저장할 Stack 객체 reverseStr 초기화
		Stack<Character> reverseStr = new Stack<>();
		
		// for 반복문을 사용해 해당 문자열의 각 글자를 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 문자열의 글자를 변수 character에 할당
			char character = string.charAt(idx);
			
			// 태그를 여는 기호가 입력된 경우
			if (character == '<') {
				
				// while 반복문을 사용해 reverseStr이 빌 때까지 순회
				while (!reverseStr.isEmpty())
					
					// pop() 및 write() 메서드를 사용해 각 글자를 거꾸로 출력
					out.write(reverseStr.pop());
				
				// write() 메서드를 사용해 글자를 그대로 출력
				out.write(character);

				// 괄호 내부의 문자임을 알려주는 변수 isInside 갱신
				isInside = true;
				
			// 태그를 닫는 기호가 입력된 경우
			} else if (character == '>') {
				
				// write() 메서드를 사용해 글자를 그대로 출력
				out.write(character);
				
				// 괄호 내부의 문자임을 알려주는 변수 isInside 갱신
				isInside = false;
				
			// 태그 내부의 문자의 경우 글자를 그대로 출력
			} else if (isInside) {
				out.write(character);
				
			// 태그 내부의 문자가 아니고 띄어쓰기인 경우
			} else if (!isInside && character == ' ') {

				// while 반복문을 사용해 reverseStr에 남아 있는 글자가 없을 때까지 글자 출력
				while (!reverseStr.isEmpty())
					out.write(reverseStr.pop());
				
				// 띄어쓰기를 그대로 출력
				out.write(character);
				
			// 태그 내부의 문자가 아닌 경우 글자를 reverseStr에 추가
			} else {
				reverseStr.add(character);
			}
		}
		
		// while 반복문을 사용해 reverseStr에 남아 있는 글자가 없을 때까지 글자 출력
		while (!reverseStr.isEmpty())
			out.write(reverseStr.pop());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}