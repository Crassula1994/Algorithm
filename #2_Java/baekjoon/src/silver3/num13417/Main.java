package silver3.num13417;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 놓여 있는 카드의 개수를 변수 cardNum에 할당
			int cardNum = Integer.parseInt(in.readLine());
			
			// 태욱이가 만들 수 있는 가장 빠른 문자열을 저장할 Deque 객체 targetString 초기화
			Deque<Character> targetString = new ArrayDeque<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 카드를 순회
			while (cardNum-- > 0) {
				
				// nextToken() 및 charAt() 메서드를 사용해 현재 카드의 알파벳을 변수 alphabet에 할당
				char alphabet = st.nextToken().charAt(0);
				
				// 첫 번째 카드인 경우 또는 가장 왼쪽에 있는 알파벳보다 사전 순으로 앞서거나 같은 경우 왼쪽에 알파벳을 추가
				if (targetString.isEmpty() || alphabet <= targetString.getFirst()) {
					targetString.addFirst(alphabet);
					
				// 현재 카드의 알파벳보다 가장 왼쪽에 있는 알파벳이 사전 순으로 앞서는 경우 오른쪽에 알파벳을 추가
				} else {
					targetString.addLast(alphabet);
				}
			}
			
			// while 반복문을 사용해 태욱이가 만들 수 있는 가장 빠른 문자열을 출력
			while (!targetString.isEmpty())
				out.write(targetString.pollFirst());
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}