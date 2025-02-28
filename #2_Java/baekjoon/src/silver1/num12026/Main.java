package silver1.num12026;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// 각 보도블록까지 이동하기 위해 필요한 에너지의 양을 초기화할 상수 MAX_AMOUNT 초기화
	static final int MAX_AMOUNT = 987654321;
	
	// 각 알파벳 다음에 위치할 알파벳을 저장할 Map 객체 nextAlphabets 초기화
	static Map<Character, Character> nextAlphabets = new HashMap<>();
	
	// put() 메서드를 사용해 각 알파벳 다음에 위치할 알파벳을 nextAlphabets에 저장
	static {
		nextAlphabets.put('B', 'O');
		nextAlphabets.put('O', 'J');
		nextAlphabets.put('J', 'B');
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보도블록의 개수를 변수 paverNum에 할당
		int paverNum = Integer.parseInt(in.readLine());
		
		// 각 보도블록의 글자 및 해당 보도블록까지 이동하기 위해 필요한 에너지 양의 최솟값을 저장할 각 변수 초기화
		char[] pavers = in.readLine().toCharArray();
		int[] minAmounts = new int[paverNum];
		
		// fill() 메서드를 사용해 해당 보도블록까지 이동하기 위해 필요한 에너지 양의 최솟값을 초기화
		Arrays.fill(minAmounts, MAX_AMOUNT);
		
		// 시작 위치의 최소 비용을 초기화
		minAmounts[0] = 0;
		
		// for 반복문을 사용해 각 보도블록을 순회
		for (int curIdx = 0; curIdx < paverNum - 1; curIdx++) {
			
			// 해당 보도블록에 갈 수 없는 경우 다음 보도블록을 순회
			if (minAmounts[curIdx] == MAX_AMOUNT)
				continue;
			
			// get() 메서드를 사용해 해당 보도블록 다음에 와야 할 알파벳을 변수 targetAlphabet에 할당
			char targetAlphabet = nextAlphabets.get(pavers[curIdx]);
			
			// for 반복문을 사용해 다음 보도블록을 순회
			for (int nextIdx = curIdx + 1; nextIdx < paverNum; nextIdx++) {
				
				// 해당 보도블록의 알파벳이 다음에 와야 할 알파벳이 아닌 경우 다음 보도블록을 순회
				if (pavers[nextIdx] != targetAlphabet)
					continue;
				
				// 다음 보도블록까지 이동하기 위해 필요한 에너지의 양을 계산해 변수 amount에 할당
				int amount = minAmounts[curIdx] + (nextIdx - curIdx) * (nextIdx - curIdx);
				
				// min() 메서드를 사용해 해당 보도블록까지 이동하기 위해 필요한 에너지 양의 최솟값을 갱신
				minAmounts[nextIdx] = Math.min(amount, minAmounts[nextIdx]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 스타트가 링크를 만나는 데 필요한 에너지 양의 최솟값을 출력
		out.write((minAmounts[paverNum - 1] == MAX_AMOUNT) ? "-1" : String.valueOf(minAmounts[paverNum - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}