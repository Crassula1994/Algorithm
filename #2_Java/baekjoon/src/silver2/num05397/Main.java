package silver2.num05397;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 강산이의 입력 순서를 변수 inputString에 할당
			String inputString = in.readLine();
			
			// 강산이의 비밀번호를 저장할 각 Stack 객체 초기화
			Stack<Character> prefixPassword = new Stack<>();
			Stack<Character> suffixPassword = new Stack<>();
			
			// for 반복문을 사용해 강산이의 각 입력을 순회
			for (int idx = 0; idx < inputString.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 입력을 변수 input에 할당
				char input = inputString.charAt(idx);
				
				// 백스페이스를 입력한 경우
				if (input == '-') {
					
					// 지울 수 있는 글자가 없는 경우 다음 입력을 순회
					if (prefixPassword.isEmpty())
						continue;
					
					// pop() 메서드를 사용해 이전 글자를 삭제
					prefixPassword.pop();
					
				// 왼쪽 화살표를 입력한 경우
				} else if (input == '<') {
					
					// 이동할 수 없는 경우 다음 입력을 순회
					if (prefixPassword.isEmpty())
						continue;
					
					// pop() 및 push() 메서드를 사용해 커서의 위치를 갱신
					suffixPassword.push(prefixPassword.pop());
		
				// 오른쪽 화살표를 입력한 경우
				} else if (input == '>') {
					
					// 이동할 수 없는 경우 다음 입력을 순회
					if (suffixPassword.isEmpty())
						continue;
					
					// pop() 및 push() 메서드를 사용해 커서의 위치를 갱신
					prefixPassword.push(suffixPassword.pop());
				
				// 알파벳 또는 숫자를 입력한 경우 글자를 삽입
				} else {
					prefixPassword.push(input);
				}
			}
			
			// while 반복문을 사용해 강산이의 비밀번호를 suffixPassword에 저장
			while (!prefixPassword.isEmpty())
				suffixPassword.push(prefixPassword.pop());
			
			// while 반복문을 사용해 강산이의 비밀번호를 출력
			while (!suffixPassword.isEmpty())
				out.write(suffixPassword.pop());
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}