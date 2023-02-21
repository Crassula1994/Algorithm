package d2.num1954;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// 한 글자인 경우 1을 출력
			if (word.length() == 1) {
				out.write("#" + (tc + 1) + " " + 1 + "\n");
			
			// 한 글자가 아닌 경우
			} else {
				
				// for 반복문을 사용해 각 글자를 순회
				for (int idx = 0; idx < word.length() / 2; idx++) {
					
					// 회문이 아닌 경우 0을 출력 후 반복문 탈출
					if (word.charAt(idx) != word.charAt(word.length() - idx - 1)) {
						out.write("#" + (tc + 1) + " " + 0 + "\n");
						break;
					}
					
					// 회문인 경우 1을 출력
					if (idx == word.length() / 2 - 1)
						out.write("#" + (tc + 1) + " " + 1 + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}