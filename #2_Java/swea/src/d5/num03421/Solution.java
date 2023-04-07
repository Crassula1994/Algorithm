package d5.num03421;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {

	// 재료의 개수와 궁합이 맞지 않는 재료 쌍의 수, 만들 수 있는 버거의 가짓수를 저장할 각 변수 초기화
	static int ingredNum;
	static int incompNum;
	static int count;
	
	// 궁합이 맞지 않는 재료 쌍의 관계를 저장할 2차원 배열 incompatibility 초기화
	static boolean[][] incompatibility;
	
	// 재료의 선택 여부를 저장할 배열 selected 초기화
	static boolean[] selected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 재료의 개수와 궁합이 맞지 않는 재료 쌍의 수를 각 변수에 할당
			ingredNum = Integer.parseInt(st.nextToken());
			incompNum = Integer.parseInt(st.nextToken());

			// 재료의 선택 여부를 저장할 배열 selected 초기화
			selected = new boolean[ingredNum + 1];
			
			// 궁합이 맞지 않는 재료 쌍의 관계를 저장할 2차원 배열 incompatibility 초기화
			incompatibility = new boolean[ingredNum + 1][ingredNum + 1];
			
			// 만들 수 있는 버거의 가짓수를 저장할 변수 count 초기화
			count = 0;
        	
			// for 반복문을 사용해 궁합이 맞지 않는 각 재료 쌍을 순회
			for (int pair = 0; pair < incompNum; pair++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 재료를 각 변수에 저장
				int ingredient1 = Integer.parseInt(st.nextToken());
				int ingredient2 = Integer.parseInt(st.nextToken());
				
				// 두 재료의 관계를 배열 incompatibility에 저장
				incompatibility[ingredient1][ingredient2] = true;
				incompatibility[ingredient2][ingredient1] = true;
			}

			// burgerMaker() 메서드를 호출해 만들 수 있는 버거의 가짓수를 갱신
			burgerMaker(0, 1);

			// write() 메서드를 사용해 만들 수 있는 버거의 가짓수를 출력
			out.write("#" + tc + " " + count + "\n");
		}	

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// burgerMaker() 메서드 정의
	public static void burgerMaker(int selectNum, int startIdx) {
		
		// 해당 가짓수를 갱신
		count++;
		
		// for 반복문을 사용해 다음 재료를 순회
		for (int idx = startIdx; idx <= ingredNum; idx++) {
			
			// 해당 재료를 선택하지 않았으며, 선택한 다른 재료와 궁합이 맞는 경우
			if (!selected[idx] && compatibilityChecker(startIdx, idx)) {
				
				// 해당 재료를 선택 처리
				selected[idx] = true;
				
				// burgerMaker() 메서드 재귀 호출
				burgerMaker(selectNum + 1, idx + 1);
				
				// 해당 재료의 선택 여부를 원상 복구
				selected[idx] = false;
			}
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// compatibilityChecker() 메서드 정의
	public static boolean compatibilityChecker(int lastIngred, int currIngred) {
		
		// for 반복문을 사용해 궁합이 맞지 않는 재료가 있는지 탐색
		for (int ingredient = 0; ingredient < lastIngred; ingredient++) {
			
			// 해당 재료를 선택했으며, 해당 재료와 궁합이 맞지 않은 경우 false 반환
			if (selected[ingredient] && incompatibility[currIngred][ingredient])
				return false;
		}
		
		// 궁합이 맞지 않는 재료가 존재하지 않는 경우 true 반환
		return true;
	}
}