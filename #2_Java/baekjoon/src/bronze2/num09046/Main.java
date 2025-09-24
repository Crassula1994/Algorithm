package bronze2.num09046;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

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
			
			// readLine() 메서드를 사용해 입력 받은 암호문을 변수 cipherText에 할당
			String cipherText = in.readLine();
			
			// 해당 암호문에서 가장 많이 등장하는 알파벳의 개수를 저장할 변수 maxCount 초기화
			int maxCount = 0;
			
			// 해당 테스트 케이스의 각 알파벳의 개수를 저장할 배열 alphabets 초기화
			int[] alphabets = new int[26];
			
			// 해당 암호문에서 가장 많이 등장하는 알파벳을 저장할 List 객체 maxAlphabets 초기화
			List<Integer> maxAlphabets = new ArrayList<>();
			
			// for 반복문을 사용해 암호문의 각 알파벳을 순회
			for (int idx = 0; idx < cipherText.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
				char character = cipherText.charAt(idx);
				
				// 해당 글자가 빈 칸인 경우 다음 알파벳을 순회
				if (character == ' ')
					continue;
				
				// 해당 알파벳의 개수를 갱신
				alphabets[character - 'a']++;
			}
			
			// for 반복문을 사용해 각 알파벳의 개수를 순회
			for (int idx = 0; idx < alphabets.length; idx++) {
				
				// 해당 알파벳의 개수가 저장된 가장 많은 알파벳의 개수보다 많은 경우
				if (alphabets[idx] > maxCount) {
					
					// 가장 많은 알파벳의 개수를 갱신
					maxCount = alphabets[idx];
					
					// clear() 및 add() 메서드를 사용해 가장 많은 알파벳을 maxAlphabets에 저장
					maxAlphabets.clear();
					maxAlphabets.add(idx);
					
				// 해당 알파벳의 개수가 저장된 가장 많은 알파벳의 개수와 같은 경우 해당 알파벳을 maxAlphabets에 저장
				} else if (alphabets[idx] == maxCount) {
					maxAlphabets.add(idx);
				}
			}
			
			// 가장 많이 나타나는 알파벳이 여러 개인 경우 '?'를 출력
			if (maxAlphabets.size() > 1) {
				out.write("?");
				
			// 가장 많이 나타나는 알파벳이 한 개인 경우 해당 알파벳을 출력
			} else {
				out.write((char) (maxAlphabets.get(0) + 'a'));
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}