package silver2.num02607;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 주어진 첫 번째 단어와 비슷한 단어의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// readLine() 메서드를 사용해 첫 번째 단어를 변수 firstWord에 할당
		String firstWord = in.readLine();
		
		// 첫 번째 단어의 각 알파벳 수를 저장할 배열 standards 초기화
		int[] standards = new int[26];
		
		// for 반복문을 사용해 첫 번째 단어의 알파벳의 개수를 갱신
		for (int idx = 0; idx < firstWord.length(); idx++)
			standards[firstWord.charAt(idx) - 'A']++;
		
		// for 반복문을 사용해 각 단어를 순회
		for (int w = 0; w < wordNum - 1; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// 해당 단어의 길이가 첫 번째 단어와 두 글자 이상 차이나는 경우 다음 단어를 순회
			if (Math.abs(word.length() - firstWord.length()) > 1)
				continue;
			
			// 첫 번째 단어와 차이 나는 글자의 수를 저장할 각 변수 초기화
			int plusCnt = 0;
			int minusCnt = 0;
			
			// 해당 단어의 각 알파벳 수를 저장할 배열 alphabets 초기화
			int[] alphabets = new int[26];
			
			// for 반복문을 사용해 해당 단어의 알파벳의 개수를 갱신
			for (int idx = 0; idx < word.length(); idx++)
				alphabets[word.charAt(idx) - 'A']++;
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < 26; idx++) {
				
				// 첫 번째 단어보다 같거나 더 많은 알파벳을 가진 경우 차이 나는 글자의 수를 갱신
				if (alphabets[idx] >= standards[idx]) {
					plusCnt += alphabets[idx] - standards[idx];
					
				// 첫 번째 단어보다 더 작은 알파벳을 가진 경우 차이 나는 글자의 수를 갱신
				} else {
					minusCnt += standards[idx] - alphabets[idx];
				}
			}
			
			// 해당 단어의 길이가 첫 번째 단어보다 한 글자 긴 경우 첫 번째 단어와 비슷한 단어의 개수를 갱신
			if (word.length() == firstWord.length() + 1) {
				count = (plusCnt == 1 && minusCnt == 0) ? count + 1 : count;
				
			// 해당 단어의 길이가 첫 번째 단어보다 한 글자 짧은 경우 첫 번째 단어와 비슷한 단어의 개수를 갱신
			} else if (word.length() == firstWord.length() - 1) {
				count = (plusCnt == 0 && minusCnt == 1) ? count + 1 : count;
				
			// 해당 단어의 길이가 첫 번째 단어와 같은 경우 첫 번째 단어와 비슷한 단어의 개수를 갱신
			} else {
				count = ((plusCnt == 0 && minusCnt == 0) || (plusCnt == 1 && minusCnt == 1)) ? count + 1 : count;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 첫 번째 단어와 비슷한 단어의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}