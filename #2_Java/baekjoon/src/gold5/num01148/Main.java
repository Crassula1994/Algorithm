package gold5.num01148;

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
		
		// 각 단어의 알파벳 개수를 저장할 List 객체 words 초기화
		List<int[]> words = new ArrayList<>();
		
		// while 반복문을 사용해 각 단어를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// 모든 단어를 확인한 경우 반복문 탈출
			if (word.equals("-"))
				break;
			
			// 해당 단어의 알파벳을 저장할 배열 alphabets 초기화
			int[] alphabets = new int[26];
			
			// for 반복문을 사용해 각 알파벳의 개수를 갱신
			for (char alphabet : word.toCharArray())
				alphabets[alphabet - 'A']++;
			
			// add() 메서드를 사용해 해당 단어의 알파벳 개수를 words에 저장
			words.add(alphabets);
		}
		
		// while 반복문을 사용해 각 퍼즐판을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 퍼즐판을 변수 puzzleBoard에 할당
			String puzzleBoard = in.readLine();
			
			// 모든 퍼즐판을 확인한 경우 반복문 탈출
			if (puzzleBoard.equals("#"))
				break;
			
			// 해당 퍼즐판에서 최소 정답의 개수와 최대 정답의 개수를 저장할 각 변수 초기화
			int minCount = Integer.MAX_VALUE;
			int maxCount = Integer.MIN_VALUE;
			
			// 해당 퍼즐판의 각 알파벳 개수, 각 알파벳을 퍼즐판 가운데에 두었을 때 만들 수 있는 단어의 수를 저장할 각 배열 초기화
			int[] alphabets = new int[26];
			int[] counts = new int[26];
			
			// for 반복문을 사용해 각 알파벳의 개수를 갱신
			for (char alphabet : puzzleBoard.toCharArray())
				alphabets[alphabet - 'A']++;
			
			// for 반복문을 사용해 각 단어를 순회
			for (int[] word : words) {
				
				// 해당 단어를 해당 퍼즐판으로 만들 수 없는 경우 다음 단어를 순회
				if (!wordChecker(word, alphabets))
					continue;
				
				// for 반복문을 사용해 각 알파벳을 순회
				for (int idx = 0; idx < word.length; idx++) {
					
					// 해당 알파벳이 단어에 존재하는 경우 이를 퍼즐판 가운데에 두었을 때 만들 수 있는 단어의 수를 갱신
					if (word[idx] > 0)
						counts[idx]++;
				}
			}
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < counts.length; idx++) {
				
				// 해당 알파벳이 퍼즐판에 존재하지 않는 경우 다음 알파벳을 순회
				if (alphabets[idx] == 0)
					continue;
				
				// min() 및 max() 메서드를 사용해 해당 퍼즐판에서 최소 정답의 개수와 최대 정답의 개수를 갱신
				minCount = Math.min(counts[idx], minCount);
				maxCount = Math.max(counts[idx], maxCount);
			}
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < counts.length; idx++) {
				
				// 해당 퍼즐판에서 최소 정답을 가지는 알파벳인 경우 이를 출력
				if (alphabets[idx] > 0 && counts[idx] == minCount)
					out.write((char) (idx + 'A'));
			}
			
			// write() 메서드를 사용해 최소 정답의 개수를 출력
			out.write(" " + minCount + " ");
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < counts.length; idx++) {
				
				// 해당 퍼즐판에서 최대 정답을 가지는 알파벳인 경우 이를 출력
				if (alphabets[idx] > 0 && counts[idx] == maxCount)
					out.write((char) (idx + 'A'));
			}
			
			// write() 메서드를 사용해 최대 정답의 개수를 출력
			out.write(" " + maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// wordChecker() 메서드 정의
	public static boolean wordChecker(int[] word, int[] puzzleBoard) {
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < 26; idx++) {
			
			// 해당 단어에서 필요한 알파벳보다 퍼즐판의 알파벳이 적은 경우 false 반환
			if (puzzleBoard[idx] < word[idx])
				return false;
		}
		
		// 해당 퍼즐판의 알파벳으로 단어를 만들 수 잇는 경우 true 반환
		return true;
	}
}