package silver3.num09436;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 0이 입력된 경우 반복문 탈출
			if (st.countTokens() == 1)
				break;
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 수 및 턴의 수를 각 변수에 할당
			int playerNum = Integer.parseInt(st.nextToken());
			int turnNum = Integer.parseInt(st.nextToken());
			
			// 현재 턴의 플레이어를 저장할 변수 curPlayer 초기화
			int curPlayer = 0;
			
			// nCopies() 메서드를 사용해 플레이어의 수만큼 0으로 채운 List 객체 counts 초기화
			List<Integer> counts = new ArrayList<>(Collections.nCopies(playerNum, 0));
			
			// while 반복문을 사용해 플레이어가 한 명이 남을 때까지 순회
			while (counts.size() > 1) {
				
				// size() 메서드를 사용해 현재 플레이어 수를 변수 curPlayerNum에 할당
				int curPlayerNum = counts.size();
				
				// for 반복문을 사용해 각 턴을 순회
				for (int turn = 0; turn < turnNum; turn++) {
					
					// get() 및 set() 메서드를 사용해 현재 플레이어의 턴 수를 갱신
					counts.set(curPlayer, counts.get(curPlayer) + 1);
					
					// 현재 플레이어를 갱신
					curPlayer = (curPlayer + 1) % curPlayerNum;
				}
				
				// remove() 메서드를 사용해 마지막 턴의 플레이어를 제거
				counts.remove((curPlayerNum + curPlayer - 1) % curPlayerNum);
				
				// 현재 플레이어를 갱신
				curPlayer = (curPlayer == 0) ? 0 : curPlayer - 1;
				
				// 남은 플레이어의 턴 수가 모두 동일한 경우 반복문 탈출
				if (countChecker(counts))
					break;
			}
			
			// get(), size(), write() 메서드를 사용해 남은 플레이어의 수 및 같아진 턴 수를 출력
			out.write(counts.size() + " " + counts.get(0) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// countChecker() 메서드 정의
	public static boolean countChecker(List<Integer> counts) {
		
		// get() 메서드를 사용해 동일한지 확인할 턴 수를 변수 targetCount에 할당
		int targetCount = counts.get(0);
		
		// for 반복문을 사용해 각 턴 수를 순회
		for (int count : counts) {
			
			// 해당 플레이어의 턴 수가 동일하지 않은 경우 false 반환
			if (count != targetCount)
				return false;
		}
		
		// 모든 플레이어의 턴 수가 동일한 경우 true 반환
		return true;
	}
}