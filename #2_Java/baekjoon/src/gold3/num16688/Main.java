package gold3.num16688;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 대회 작가가 만들 수 있는 유효한 대회의 수를 나눌 제수를 변수 DIVISOR에 할당
	static final int DIVISOR = 998244353;
	
	// 문제 난이도의 수 및 대회에 사용할 문제의 수를 저장할 각 변수 초기화
	static int totalDiff = 0;
	static int targetCount;
	
	// 각 문제를 선택했을 때 만들 수 있는 유효한 대회의 수를 저장할 2차원 배열 contestCounts 초기화
	static Long[][] contestCounts;
	
	// 고유 번호별 문제의 개수를 저장할 List 객체 problemCounts 초기화
	static List<Integer> problemCounts = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 총 문제의 수 및 대회에 사용할 문제의 수를 각 변수에 할당
		int problemNum = Integer.parseInt(st.nextToken());
		targetCount = Integer.parseInt(st.nextToken());
		
		// 문제 난이도별 고유 번호를 저장할 Map 객체 problems 초기화
		Map<Integer, Integer> problems = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 문제를 순회
		while (problemNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제의 난이도를 변수 difficulty에 할당
			int difficulty = Integer.parseInt(st.nextToken());
			
			// 고유 번호가 부여된 난이도인 경우
			if (problems.containsKey(difficulty)) {
				
				// get() 메서드를 사용해 해당 난이도의 고유 번호를 변수 number에 할당
				int number = problems.get(difficulty);
				
				// get() 및 set() 메서드를 사용해 해당 난이도의 문제의 개수를 problemCounts에 저장
				problemCounts.set(number, problemCounts.get(number) + 1);
				
			// 고유 번호가 부여되지 않은 난이도인 경우
			} else {
				
				// put() 메서드를 사용해 고유 번호를 problems에 저장
				problems.put(difficulty, totalDiff++);
				
				// add() 메서드를 사용해 해당 난이도의 개수를 problemCounts에 초기화
				problemCounts.add(1);
			}
		}
		
		// size() 메서드를 사용해 각 문제를 선택했을 때 만들 수 있는 유효한 대회의 수를 저장할 2차원 배열 contestCounts 초기화
		contestCounts = new Long[totalDiff + 1][targetCount + 1];
		
		// contestCounter(), valueOf(), write() 메서드를 사용해 대회 작가가 만들 수 있는 유효한 대회의 수를 출력
		out.write(String.valueOf(contestCounter(0, 0)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// contestCounter() 메서드 정의
	public static long contestCounter(int curNumber, int selectedNum) {
		
		// 해당 문제의 선택에 따른 유효한 대회의 수를 이미 계산한 경우 해당 개수를 반환
		if (contestCounts[curNumber][selectedNum] != null)
			return contestCounts[curNumber][selectedNum];
		
		// 해당 문제의 선택으로 대회에 사용할 문제의 수를 충족한 경우 해당 경우의 수를 반환
		if (selectedNum == targetCount)
			return contestCounts[curNumber][selectedNum] = 1L;
		
		// 모든 문제를 확인했음에도 사용할 문제의 수를 충족하지 못한 경우 0을 반환
		if (curNumber == totalDiff)
			return contestCounts[curNumber][selectedNum] = 0L;
		
		// contestCounter() 및 get() 메서드를 사용해 해당 문제의 선택에 따른 유효한 대회의 수를 반환
		return contestCounts[curNumber][selectedNum]
				= (contestCounter(curNumber + 1, selectedNum + 1) * problemCounts.get(curNumber)
				+ contestCounter(curNumber + 1, selectedNum)) % DIVISOR;
	}
}