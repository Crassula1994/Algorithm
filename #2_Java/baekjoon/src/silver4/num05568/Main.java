package silver4.num05568;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// 카드의 수 및 선택한 카드의 수를 저장할 각 변수 초기화
	static int cardNum;
	static int selectedNum;
	
	// 각 카드의 숫자 및 해당 카드의 선택 여부를 저장할 각 배열 초기화
	static String[] cards;
	static boolean[] selected;
	
	// 카드로 만들 수 있는 정수를 저장할 Set 객체 numbers 초기화
	static Set<Integer> numbers;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 수 및 선택한 카드의 수를 각 변수에 할당
		cardNum = Integer.parseInt(in.readLine());
		selectedNum = Integer.parseInt(in.readLine());
		
		// 각 카드의 숫자 및 해당 카드의 선택 여부를 저장할 각 배열 초기화
		cards = new String[cardNum];
		selected = new boolean[cardNum];
		
		// 카드로 만들 수 있는 정수를 저장할 Set 객체 numbers 초기화
		numbers = new HashSet<>();
		
		// for 반복문을 사용해 입력 받은 카드의 숫자를 배열 cards에 저장
		for (int idx = 0; idx < cardNum; idx++)
			cards[idx] = in.readLine();
		
		// numberMaker() 메서드를 호출해 상근이가 만들 수 있는 정수의 개수를 갱신
		numberMaker(0, "");
		
		// size(), valueOf(), write() 메서드를 사용해 상근이가 만들 수 있는 정수의 개수를 출력
		out.write(String.valueOf(numbers.size()));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// numberMaker() 메서드 정의
	public static void numberMaker(int selectedCnt, String numStr) {
		
		// 모든 카드를 선택한 경우
		if (selectedCnt == selectedNum) {
			
			// parseInt() 및 add() 메서드를 사용해 만든 정수를 numbers에 추가
			numbers.add(Integer.parseInt(numStr));
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = 0; idx < cardNum; idx++) {
			
			// 해당 카드를 선택한 경우 다음 카드를 순회
			if (selected[idx])
				continue;
			
			// 해당 카드를 선택한 것으로 처리
			selected[idx] = true;
			
			// numberMaker() 메서드 재귀 호출
			numberMaker(selectedCnt + 1, numStr + cards[idx]);
			
			// 해당 카드를 선택하지 않은 것으로 처리
			selected[idx] = false;
		}
	}
}