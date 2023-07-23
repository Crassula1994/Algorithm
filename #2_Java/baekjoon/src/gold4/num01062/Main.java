package gold4.num01062;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 단어의 개수, 가르칠 수 있는 글자의 수, 학생들이 읽을 수 있는 단어 개수의 최댓값을 저장할 각 변수 초기화
	static int wordNum;
	static int alphabetNum;
	static int maxCnt = 0;
	
	// 남극 단어의 목록을 저장하고, 각 글자를 가르쳤는지 여부를 나타낼 각 배열 초기화
	static String[] words;
	static boolean[] isKnown = new boolean[26];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수 및 가르칠 수 있는 글자의 수를 각 변수에 할당
		wordNum = Integer.parseInt(st.nextToken());
		alphabetNum = Integer.parseInt(st.nextToken());
		
		// 남극 단어의 목록을 저장할 배열 words 초기화
		words = new String[wordNum];
		
		// for 반복문을 사용해 각 단어를 순회
		for (int idx = 0; idx < wordNum; idx++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// length() 및 substring() 메서드를 사용해 접두사와 접미사를 제외한 단어를 배열 words에 저장
			words[idx] = word.substring(4, word.length() - 4);
		}
		
		// 가르칠 수 있는 글자의 수가 5글자 미만인 경우 0을 출력
		if (alphabetNum < 5) {
			out.write(String.valueOf(0));
		
		// 가르칠 수 있는 글자의 수가 26글자인 경우 입력 받은 단어의 개수를 출력
		} else if (alphabetNum == 26) {
			out.write(String.valueOf(wordNum));
			
		// 가르칠 수 있는 글자의 수가 5글자 이상 25글자 이하인 경우
		} else {
			
			// 남극언어에 필수적으로 포함되는 글자 'a', 'c', 'i', 'n', 't'를 가르친 것으로 처리
			isKnown[0] = true;
			isKnown[2] = true;
			isKnown[8] = true;
			isKnown[13] = true;
			isKnown[19] = true;
			
			// wordCounter() 메서드를 호출해 학생들이 읽을 수 있는 단어 개수의 최댓값을 갱신
			wordCounter(0, 0);
			
			// valueOf() 및 write() 메서드를 사용해 학생들이 읽을 수 있는 단어 개수의 최댓값을 출력
			out.write(String.valueOf(maxCnt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// wordCounter() 메서드 정의
	public static void wordCounter(int selected, int startIdx) {
		
		// 모든 알파벳을 선택한 경우
		if (selected == alphabetNum - 5) {
			
			// 읽을 수 있는 단어의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 저장된 각 단어를 순회
			for (int idx = 0; idx < wordNum; idx++) {
				
				// 해당 단어를 변수 word에 할당
				String word = words[idx];
				
				// 해당 단어를 읽을 수 있는지 여부를 나타내는 변수 isReadable 초기화
				boolean isReadable = true;
				
				// for 반복문을 사용해 각 글자를 순회
				for (int c = 0; c < word.length(); c++) {
					
					// 해당 글자를 읽지 못하는 경우 해당 단어를 읽을 수 잇는지 여부를 갱신 후 반복문 탈출
					if (!isKnown[word.charAt(c) - 'a']) {
						isReadable = false;
						break;
					}
				}
				
				// 해당 단어를 읽을 수 있는 경우 읽을 수 있는 단어의 개수를 갱신
				if (isReadable)
					count++;
			}
			
			// max() 메서드를 사용해 학생들이 읽을 수 있는 단어 개수의 최댓값을 갱신
			maxCnt = Math.max(count, maxCnt);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = startIdx; idx < 26; idx++) {
			
			// 해당 글자를 배우지 않은 경우
			if (!isKnown[idx]) {
				
				// 해당 글자를 배운 것으로 처리
				isKnown[idx] = true;
				
				// wordCounter() 메서드 재귀 호출
				wordCounter(selected + 1, idx + 1);
				
				// 해당 글자를 배우지 않은 것으로 처리
				isKnown[idx] = false;
			}
		}
	}
}