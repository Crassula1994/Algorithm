package silver2.num02961;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 재료의 개수, 신맛과 쓴맛의 가장 작은 차이를 저장할 각 변수 초기화
	static int ingredientNum;
	static int minDifference = Integer.MAX_VALUE;
	
	// 각 재료의 정보를 저장할 2차원 배열 ingredients 초기화
	static int[][] ingredients; 
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 재료의 개수를 변수 ingredientNum에 할당
		ingredientNum = Integer.parseInt(in.readLine());
		
		// 각 재료의 사용 여부 및 각 재료의 정보를 저장할 각 배열 초기화
		ingredients = new int[ingredientNum][2];
		
		// for 반복문을 사용해 입력 받은 각 재료의 정보를 순회
		for (int ingredient = 0; ingredient < ingredientNum; ingredient++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 신맛과 쓴맛을 2차원 배열 ingredients에 저장
			ingredients[ingredient][0] = Integer.parseInt(st.nextToken());
			ingredients[ingredient][1] = Integer.parseInt(st.nextToken());
		}
		
		// foodMaker() 메서드를 호출해 신맛과 쓴맛의 가장 작은 차이를 갱신
		foodMaker(0, 0, 1, 0);
		
		// valueOf() 및 write() 메서드를 사용해 신맛과 쓴맛의 가장 작은 차이를 출력
		out.write(String.valueOf(minDifference));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// foodMaker() 메서드 정의
	public static void foodMaker(int curIdx, int selected, int sourness, int bitterness) {
		
		// 모든 재료를 확인한 경우
		if (curIdx == ingredientNum) {
			
			// 하나 이상의 재료를 사용한 경우 신맛과 쓴맛의 가장 작은 차이를 갱신
			if (selected > 0)
				minDifference = Math.min(Math.abs(sourness - bitterness), minDifference);
			
			// 메서드 종료
			return;
		}
		
		// 현재 재료를 사용한 경우와 사용하지 않은 경우를 상정해 foodMaker() 메서드 재귀 호출
		foodMaker(curIdx + 1, selected + 1, sourness * ingredients[curIdx][0], bitterness + ingredients[curIdx][1]);
		foodMaker(curIdx + 1, selected, sourness, bitterness);
	}
}