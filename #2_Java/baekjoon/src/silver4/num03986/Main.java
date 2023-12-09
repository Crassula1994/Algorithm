package silver4.num03986;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 좋은 단어의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 단어를 차례로 순회
		for (int w = 0; w < wordNum; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// 각 알파벳을 저장할 Stack 객체 goodWord 초기화
			Stack<Character> goodWord = new Stack<>();
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < word.length(); idx++) {
				
				// charAt() 메서드를 사용해 입력 받은 알파벳을 변수 alphabet에 할당
				char alphabet = word.charAt(idx);
				
				// goodWord가 비어 있거나 다른 알파벳인 경우 goodWord에 알파벳을 추가
				if (goodWord.isEmpty() || goodWord.peek() != alphabet) {
					goodWord.push(alphabet);
					
				// 같은 알파벳인 경우 goodWord에서 앞의 알파벳을 제거
				} else {
					goodWord.pop();
				}
			}
			
			// 좋은 단어인 경우 좋은 단어의 개수를 갱신
			if (goodWord.isEmpty())
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 좋은 단어의 개수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}