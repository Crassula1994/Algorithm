package gold4.num04964;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 알파벳의 등장 여부, 0이 될 수 없는지 여부, 수식에서의 가중치, 각 숫자의 사용 여부를 저장할 각 배열 초기화
	static boolean[] alphabets;
	static boolean[] isNotZero;
	static int[] weights;
	static boolean[] digits;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
			int wordNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (wordNum == 0)
				break;
			
			// 각 알파벳의 등장 여부, 0이 될 수 없는지 여부, 각 수식에서의 가중치, 각 숫자의 사용 여부를 저장할 각 배열 초기화
			alphabets = new boolean[26];
			isNotZero = new boolean[26];
			weights = new int[26];
			digits = new boolean[10];
			
			// while 반복문을 사용해 각 단어를 순회
			while (wordNum-- > 0) {
				
				// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 단어를 배열 word에 할당
				char[] word = in.readLine().toCharArray();
				
				// 해당 단어의 가중치를 저장할 변수 weight 초기화
				int weight = (wordNum == 0) ? -1 : 1;
				
				// 해당 단어가 두 글자 이상인 경우 해당 단어의 처음에 위치한 알파벳의 0이 될 수 없는지 여부를 갱신
				if (word.length > 1)
					isNotZero[word[0] - 'A'] = true;
				
				// for 반복문을 사용해 단어의 각 알파벳을 거꾸로 순회
				for (int idx = word.length - 1; idx >= 0; idx--) {
					
					// 해당 알파벳의 순서를 변수 order에 할당
					int order = word[idx] - 'A';
					
					// 해당 알파벳의 등장 여부 및 수식에서의 가중치를 갱신
					alphabets[order] = true;
					weights[order] += weight;
					
					// 알파벳의 가중치를 갱신
					weight *= 10;
				}
			}
			
			// methodCounter() 및 write() 메서드를 사용해 단어 덧셈을 풀 수 있는 방법의 수를 출력
			out.write(methodCounter(0, 0) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// methodCounter() 메서드 정의
	public static long methodCounter(int curOrder, long result) {
		
		// 모든 알파벳을 확인한 경우 해당 방법이 가능한지 여부에 따라 단어 덧셈을 풀 수 있는 방법의 수를 반환
		if (curOrder == 26)
			return (result == 0) ? 1 : 0;
		
		// 현재 알파벳이 등장하지 않는 경우 methodCounter() 메서드를 재귀 호출해 그 결과를 반환
		if (!alphabets[curOrder])
			return methodCounter(curOrder + 1, result);
		
		// 단어 덧셈을 풀 수 있는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int digit = 0; digit < 10; digit++) {
			
			// 해당 숫자를 이미 사용했거나 해당 알파벳이 0이 될 수 없는 경우 다음 숫자를 순회
			if (digits[digit] || (digit == 0 && isNotZero[curOrder]))
				continue;
			
			// 해당 숫자를 사용한 것으로 처리
			digits[digit] = true;
			
			// methodCounter() 메서드를 재귀 호출해 단어 덧셈을 풀 수 있는 방법의 수를 갱신
			count += methodCounter(curOrder + 1, result + weights[curOrder] * digit);
			
			// 해당 숫자를 사용하지 않은 것으로 원상복구
			digits[digit] = false;
		}
		
		// 단어 덧셈을 풀 수 있는 방법의 수를 반환
		return count;
	}
}