package silver5.num02303;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 해당 사람의 가장 큰 점수를 저장할 변수 maxScore 초기화
	static int maxScore;
	
	// 각 사람의 카드 및 해당 카드 선택 여부를 저장할 각 배열 초기화
	static int[] cards;
	static boolean[] selected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 게임에서 이긴 사람의 번호와 그 숫자를 저장할 각 변수 초기화
		int winNumber = 0;
		int winScore = 0;
		
		// for 반복문을 사용해 각 사람을 순회
		for (int number = 1; number <= personNum; number++) {
			
			// 해당 사람의 가장 큰 점수를 저장할 변수 maxScore 초기화
			maxScore = 0;
			
			// 해당 사람의 카드 및 해당 카드 선택 여부를 저장할 각 배열 초기화
			cards = new int[5];
			selected = new boolean[5];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 다섯 장의 카드를 배열 cards에 저장
			for (int idx = 0; idx < 5; idx++)
				cards[idx] = Integer.parseInt(st.nextToken());
			
			// scoreCalculator() 메서드를 사용해 해당 사람이 카드로 만들 수 있는 가장 큰 점수를 갱신
			scoreCalculator(0, 0, 0);
			
			// 해당 사람이 만들 수 있는 가장 큰 점수가 저장된 가장 큰 점수보다 같거나 큰 경우
			if (maxScore >= winScore) {
				
				// 게임에서 이긴 사람의 번호와 그 숫자를 갱신
				winNumber = number;
				winScore = maxScore;
			}
		}
			
		// valueOf() 및 write() 메서드를 사용해 게임에서 이긴 사람의 번호를 출력
		out.write(String.valueOf(winNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// scoreCalculator() 메서드 정의
	public static void scoreCalculator(int selectedCard, int curCard, int sum) {
		
		// 세 장의 카드를 선택한 경우 해당 사람이 만들 수 있는 가장 큰 점수를 갱신 후 메서드 종료
		if (selectedCard == 3) {
			maxScore = Math.max(sum % 10, maxScore);
			return;
		}
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = curCard; idx < 5; idx++) {
			
			// 해당 카드를 이미 선택한 경우 다음 카드를 순회
			if (selected[idx])
				continue;
			
			// 해당 카드를 선택 처리
			selected[idx] = true;
			
			// scoreCalculator() 메서드 재귀 호출
			scoreCalculator(selectedCard + 1, idx + 1, sum + cards[idx]);
			
			// 해당 카드를 선택하지 않은 것으로 원상 복구
			selected[idx] = false;
		}
	}
}