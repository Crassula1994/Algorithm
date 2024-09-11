package gold5.num21315;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 카드의 수를 저장할 변수 cardNum 초기화
	static int cardNum;
	
	// 2번의 (2, K) - 섞기 전후의 카드 더미를 저장할 각 배열 초기화
	static int[] cards;
	static int[] result;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 수를 변수 cardNum에 할당
		cardNum = Integer.parseInt(in.readLine());
		
		// 2번의 (2, K) - 섞기 전후의 카드 더미를 저장할 각 배열 초기화
		cards = new int[cardNum];
		result = new int[cardNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 2번의 (2, K) - 섞기 후의 카드 더미를 배열 result에 저장
		for (int idx = 0; idx < result.length; idx++)
			result[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 가능한 섞는 횟수의 조합을 순회
		outer: for (int cnt1 = 1; Math.pow(2, cnt1) <= cardNum; cnt1++) {
			for (int cnt2 = 1; Math.pow(2, cnt2) <= cardNum; cnt2++) {
				
				// for 반복문을 사용해 초기 카드 더미를 배열 cards에 저장
				for (int idx = 0; idx < cards.length; idx++)
					cards[idx] = idx + 1;
				
				// cardShuffler() 메서드를 호출해 카드를 차례로 (2, K) - 섞기한 결과를 배열 cards에 저장
				cardShuffler(cnt1);
				cardShuffler(cnt2);
				
				// 카드를 차례로 (2, K) - 섞기한 결과가 일치하는 경우 해당 섞는 조합을 출력 후 반복문 탈출 
				if (cardChecker()) {
					out.write(cnt1 + " " + cnt2);
					break outer;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cardShuffler() 메서드 정의
	public static void cardShuffler(int stageCnt) {
		
		// for 반복문을 사용해 각 단계를 순회
		for (int stage = 1, endIdx = cardNum; stage <= stageCnt + 1; stage++) {
			
			// 각 카드를 옮긴 결과를 저장할 인덱스를 나타낼 변수 newIdx 초기화
			int newIdx = 0;
			
			// pow() 메서드를 사용해 카드 더미에서 올릴 카드의 개수를 계산하고 변수 count에 할당
			int count = (int) Math.pow(2, stageCnt - stage + 1);
			
			// 현재 단계를 수행한 결과를 저장할 배열 newCards 초기화
			int[] newCards = new int[cardNum];
			
			// for 반복문을 사용해 각 카드를 카드 더미의 맨 위로 이동
			for (int idx = endIdx - count; idx < endIdx; idx++) {
				newCards[newIdx++] = cards[idx];
				cards[idx] = 0;
			}
			
			// for 반복문을 사용해 각 카드를 순회
			for (int idx = 0; idx < cards.length; idx++) {
				
				// 현재 카드를 이미 이동시킨 경우 다음 카드를 순회
				if (cards[idx] == 0)
					continue;
				
				// 남은 카드를 배열 newCards에 저장
				newCards[newIdx++] = cards[idx];
			}
			
			// clone() 메서드를 사용해 현재 단계를 수행한 결과를 기존의 카드 뭉치에 갱신
			cards = newCards.clone();
			
			// 다음 단계에서 이동시킬 카드의 마지막 위치를 갱신
			endIdx = count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cardChecker() 메서드 정의
	public static boolean cardChecker() {
		
		// for 반복문을 사용해 각 카드를 차례로 순회
		for (int idx = 0; idx < cardNum; idx++) {
			
			// 결과가 일치하지 않는 경우 false 반환
			if (cards[idx] != result[idx])
				return false;
		}
		
		// 결과가 일치하는 경우 true 반환
		return true;
	}
}