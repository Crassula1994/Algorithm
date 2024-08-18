package silver1.num04889;

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
		
		// 각 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 targetString에 할당
			char[] targetString = in.readLine().toCharArray();
			
			// 입력의 마지막 줄인 경우 반복문 탈출
			if (targetString[0] == '-')
				break;
			
			// 주어진 문자열을 안정적으로 바꾸는 데 필요한 최소 연산의 수를 저장할 변수 minCount 초기화
			int minCount = 0;
			
			// 해당 문자열이 안정적인 문자열인지 여부를 확인할 Stack 객체 stringChecker 초기화
			Stack<Character> stringChecker = new Stack<>();
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < targetString.length; idx++) {
				
				// 해당 글자가 닫는 괄호인 경우
				if (targetString[idx] == '}') {
					
					// stringChecker가 빈 경우 최소 연산의 수를 갱신
					if (stringChecker.isEmpty()) {
						minCount++;
					
					// stringChecker에 여는 괄호가 있는 경우 여는 괄호 제거 후 다음 글자 순회
					} else {
						stringChecker.pop();
						continue;
					}
				}
				
				// push() 메서드를 사용해 stringChecker에 여는 괄호 추가
				stringChecker.push('{');
			}
			
			// size() 메서드를 사용해 최소 연산의 수를 갱신
			minCount += stringChecker.size() / 2;
			
			// write() 메서드를 사용해 주어진 문자열을 안정적으로 바꾸는 데 필요한 최소 연산의 수를 출력
			out.write(++testCase + ". " + minCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}