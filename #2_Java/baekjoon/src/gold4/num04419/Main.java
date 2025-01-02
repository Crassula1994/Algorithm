package gold4.num04419;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 후보자의 수, 총 득표 수를 저장할 각 변수 초기화
	static int candidateNum;
	static int totalCount;
	
	// 각 후보자의 탈락 여부 및 투표 결과를 저장할 각 배열 초기화
	static boolean[] eliminated;
	static int[] counts;
	
	// 각 유권자의 투표 결과를 저장할 List 객체 ballots 초기화
	static List<int[]> ballots;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보자의 수를 변수 candidateNum에 할당
		candidateNum = Integer.parseInt(in.readLine());
		
		// 각 후보자의 탈락 여부 및 투표 결과를 저장할 각 배열 초기화
		eliminated = new boolean[candidateNum + 1];
		counts = new int[candidateNum + 1];
		
		// 각 유권자의 투표 결과를 저장할 List 객체 ballots 초기화
		ballots = new ArrayList<>();
		
		// 각 후보자의 번호와 이름을 저장할 Map 객체 candidates 초기화
		Map<Integer, String> candidates = new HashMap<>();
		
		// for 반복문을 사용해 각 후보자의 번호와 이름을 candidates에 저장
		for (int number = 1; number <= candidateNum; number++)
			candidates.put(number, in.readLine());
		
		// 각 유권자의 투표 결과를 저장할 변수 result 초기화
		String result;
		
		// while 반복문을 사용해 각 유권자의 투표 결과를 순회
		while ((result = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(result);
			
			// 해당 유권자의 투표 결과를 저장할 배열 ballot 초기화
			int[] ballot = new int[candidateNum];
			
			// for 반복문을 사용해 해당 유권자의 투표 결과를 배열 ballot에 저장
			for (int idx = 0; idx < ballot.length; idx++)
				ballot[idx] = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 유권자의 투표 결과를 ballots에 저장
			ballots.add(ballot);
		}
		
		// size() 메서드를 사용해 총 득표 수를 변수 totalCount에 저장
		totalCount = ballots.size();
		
		// while 반복문을 사용해 승자를 찾을 때까지 순회
		while (true) {
			
			// ballotCounter() 메서드를 호출해 투표 결과를 갱신
			ballotCounter();
			
			// winnerChecker() 메서드를 호출해 승자 후보를 List 객체 winners에 할당
			List<Integer> winners = winnerChecker();
			
			// 승자 후보가 존재하는 경우
			if (!winners.isEmpty()) {
				
				// for 반복문을 사용해 승자 후보를 출력
				for (int candidate : winners)
					out.write(candidates.get(candidate) + "\n");
				
				// 반복문 탈출
				break;
			}
			
			// candidateEliminator() 메서드를 호출해 최소 득표한 후보자를 제거
			candidateEliminator();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ballotCounter() 메서드 정의
	public static void ballotCounter() {
		
		// fill() 메서드를 사용해 각 후보자의 투표 결과를 저장할 배열 counts 초기화
		Arrays.fill(counts, 0);
		
		// for 반복문을 사용해 각 유권자의 투표 결과를 순회
		for (int[] ballot : ballots) {
			
			// for 반복문을 사용해 해당 유권자가 기재한 후보자의 우선순위를 순회
			for (int candidate : ballot) {
				
				// 해당 후보자가 탈락하지 않은 경우 해당 후보자의 득표 수를 갱신 후 반복문 탈출
				if (!eliminated[candidate]) {
					counts[candidate]++;
					break;
				}
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// winnerChecker() 메서드 정의
	public static List<Integer> winnerChecker() {
		
		// 가장 많은 득표 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 승자 후보를 저장할 List 객체 winners 초기화
		List<Integer> winners = new ArrayList<>();
		
		// for 반복문을 사용해 각 후보를 순회
		for (int candidate = 1; candidate <= candidateNum; candidate++) {
			
			// 해당 후보자가 탈락한 경우 다음 후보자를 순회
			if (eliminated[candidate])
				continue;
			
			// 해당 후보자의 득표 수가 저장된 가장 많은 득표 수보다 많은 경우
			if (counts[candidate] > maxCount) {
				
				// 가장 많은 득표 수를 갱신
				maxCount = counts[candidate];
				
				// clear() 및 add() 메서드를 사용해 해당 후보자를 승자 후보에 추가
				winners.clear();
				winners.add(candidate);
				
			// 해당 후보자의 득표 수가 저장된 가장 많은 득표 수와 같은 경우 해당 후보자를 승자 후보에 추가
			} else if (counts[candidate] == maxCount) {
				winners.add(candidate);
			}
		}
		
		// 모든 후보자가 동률을 이뤘거나 과반수를 득표한 후보자가 있는 경우 승자 후보를 저장할 List 객체 반환
		if (maxCount * winners.size() == totalCount || maxCount > totalCount / 2)
			return winners;
		
		// 과반수를 득표한 후보자가 없는 경우 빈 List 객체 반환
		return new ArrayList<>();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// candidateEliminator() 메서드 정의
	public static void candidateEliminator() {
		
		// 가장 적은 득표 수를 저장할 변수 minCount 초기화
		int minCount = totalCount;
		
		// 패자 후보를 저장할 List 객체 losers 초기화
		List<Integer> losers = new ArrayList<>();
		
		// for 반복문을 사용해 각 후보를 순회
		for (int candidate = 1; candidate <= candidateNum; candidate++) {
			
			// 해당 후보자가 탈락한 경우 다음 후보자를 순회
			if (eliminated[candidate])
				continue;
			
			// 해당 후보자의 득표 수가 저장된 가장 적은 득표 수보다 적은 경우
			if (counts[candidate] < minCount) {
				
				// 가장 적은 득표 수를 갱신
				minCount = counts[candidate];
				
				// clear() 및 add() 메서드를 사용해 해당 후보자를 패자 후보에 추가
				losers.clear();
				losers.add(candidate);
				
			// 해당 후보자의 득표 수가 저장된 가장 적은 득표 수와 같은 경우 해당 후보자를 패자 후보에 추가
			} else if (counts[candidate] == minCount) {
				losers.add(candidate);
			}
		}
		
		// for 반복문을 사용해 패자 후보를 제거 처리
		for (int candidate : losers)
			eliminated[candidate] = true;
	}
}