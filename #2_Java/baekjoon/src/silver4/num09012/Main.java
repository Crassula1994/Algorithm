package silver4.num09012;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 데이터의 개수를 변수 dataNum에 할당
		int dataNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 데이터를 순회
		for (int d = 0; d < dataNum; d++) {
			
			// readLine() 메서드를 사용해 입력 받은 데이터를 변수 data에 할당
			String data = in.readLine();
			
			// 각 괄호 문자를 저장할 Stack 객체 psStack 초기화
			Stack<Character> psStack = new Stack<>();
			
			// for 반복문을 사용해 각 괄호 문자를 순회
			for (int idx = 0; idx < data.length(); idx++) {
				
				// push() 메서드를 사용해 괄호 문자를 psStack에 추가
				psStack.push(data.charAt(idx));
				
				// 추가한 문자가 ')'이고 두 개 이상의 문자가 담겼으며, 앞선 문자가 '('인 경우
				if (data.charAt(idx) == ')' && psStack.size() > 1 && psStack.get(psStack.size() - 2) == '(') {
					
					// pop() 메서드를 사용해 psStack의 괄호 문자의 쌍을 제거
					psStack.pop();
					psStack.pop();					
				}
			}
			
			// VPS인지 나타내는 문자열을 변수 isVps에 할당
			String isVps = (psStack.size() != 0) ? "NO" : "YES"; 
			
			// write() 메서드를 사용해 isVps를 출력
			out.write(isVps + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}