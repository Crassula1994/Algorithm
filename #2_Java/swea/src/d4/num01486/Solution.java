package d4.num01486;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// 점원의 수, 목표 높이, 목표 높이와의 최소 차이를 저장할 각 변수 초기화
	static int clerkNum;
	static int targetHeight;
	static int minDiff;

    // 각 점원의 키를 저장할 배열 heights 초기화
    static int[] heights;

    // ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for(int tc = 1; tc <= testCase; tc++) {

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점원의 수와 목표 높이를 각 변수에 할당
			clerkNum = Integer.parseInt(st.nextToken());
			targetHeight = Integer.parseInt(st.nextToken());

			// 각 점원의 키를 저장할 배열 heights 초기화
			heights = new int[clerkNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 점원의 키를 배열 heights에 저장
			for (int idx = 0; idx < clerkNum; idx++)
				heights[idx] = Integer.parseInt(st.nextToken());
			
			// 목표 높이와의 최소 차이를 저장할 변수 minDiff 초기화
			minDiff = Integer.MAX_VALUE;
			
			// heightCalculator() 메서드를 호출해 목표 높이와의 최소 차이를 변수 minDiff에 저장
			heightCalculator(0, 0);

			// write() 메서드를 사용해 목표 높이와의 최소 차이를 출력
			out.write("#" + tc + " " + minDiff + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// heightCalculator() 메서드 정의
	public static void heightCalculator(int idx, int sum) {
    
		// 해당 높이가 목표 높이 이상을 만족했을 경우
		if (sum >= targetHeight) {
			
			// min() 메서드를 사용해 목표 높이와의 최소 차이를 갱신
			minDiff = Math.min(sum - targetHeight, minDiff);
			
		// 해당 높이가 목표 높이를 만족하지 못한 경우
		} else {
			
			// 마지막 점원에 도달한 경우 메서드 종료
			if (idx == clerkNum)
				return;
			
			// 해당 점원을 선택했을 경우를 상정해 heightCalculator() 메서드 재귀 호출
			heightCalculator(idx + 1, sum + heights[idx]);
			
			// 해당 점원을 선택하지 않았을 경우를 상정해 heightCalculator() 메서드 재귀 호출
			heightCalculator(idx + 1, sum);
		}
	}
}