package d3.num05215;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {

	// 재료의 수와 제한 칼로리, 맛에 대한 점수가 가장 높은 햄버거의 점수를 저장할 각 변수 초기화
	static int ingredNum;
	static int calorieLimit;
	static int maxScore;
	
	// 각 재료의 맛에 대한 점수와 칼로리를 저장할 각 배열 초기화
	static int[] scores;
	static int[] calories;
	
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

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 재료의 수와 제한 칼로리를 각 변수에 할당
			ingredNum = Integer.parseInt(st.nextToken());
			calorieLimit = Integer.parseInt(st.nextToken());

			// 각 재료의 맛에 대한 점수와 칼로리를 저장할 각 배열 초기화
			scores = new int[ingredNum];
			calories = new int[ingredNum];
			
			// for 반복문을 사용해 각 배열의 원소를 순회
			for (int idx = 0; idx < ingredNum; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 재료의 맛에 대한 점수와 칼로리를 각 배열에 저장
				scores[idx] = Integer.parseInt(st.nextToken());
				calories[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 맛에 대한 점수가 가장 높은 햄버거의 점수를 저장할 변수 maxScore 초기화
			maxScore = 0;
        	
			// burgerMaker() 메서드를 호출해 맛에 대한 점수가 가장 높은 햄버거의 점수를 갱신
			burgerMaker(0, 0, 0);

			// write() 메서드를 사용해 맛에 대한 점수가 가장 높은 햄버거의 점수를 출력
			out.write("#" + tc + " " + maxScore + "\n");
		}	

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// burgerMaker() 메서드 정의
	public static void burgerMaker(int startIdx, int scoreSum, int calorieSum) {
		
		// 해당 재료의 조합이 칼로리 제한을 넘긴 경우 메서드 종료
		if (calorieSum > calorieLimit)
			return;
		
		// 마지막 재료까지 모두 검토한 경우
		if (startIdx == ingredNum) {
			
			// max() 메서드를 사용해 맛에 대한 점수가 가장 높은 햄버거의 점수를 갱신 후 메서드 종료
			maxScore = Math.max(scoreSum, maxScore);
			return;
		}
		
		// 해당 재료를 선택했을 때와 선택하지 않았을 때를 상정해 burgerMaker() 메서드 재귀 호출
		burgerMaker(startIdx + 1, scoreSum + scores[startIdx], calorieSum + calories[startIdx]);
		burgerMaker(startIdx + 1, scoreSum, calorieSum);
	}
}