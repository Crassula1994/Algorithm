package gold5.num12865;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 물품의 무게와 가치, 각 물품들의 가치합의 최댓값을 저장할 각 2차원 배열 초기화
	static int[][] itemInfo;
	static Integer[][] maxValues;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물품의 수와 준서가 버틸 수 있는 무게를 각 변수에 할당
		int itemNum = Integer.parseInt(st.nextToken());
		int weightLimit = Integer.parseInt(st.nextToken());
		
		// 각 물품의 무게와 가치, 각 물품들의 가치합의 최댓값을 저장할 각 2차원 배열 초기화
		itemInfo = new int[itemNum][2];
		maxValues = new Integer[itemNum][weightLimit + 1];
		
		// for 반복문을 사용해 각 물품을 순회
		for (int item = 0; item < itemNum; item++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물품의 무게와 가치를 배열 itemInfo에 저장
			itemInfo[item][0] = Integer.parseInt(st.nextToken());
			itemInfo[item][1] = Integer.parseInt(st.nextToken());
		}
		
		// maxValueFinder() 메서드를 호출해 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 변수 maxValue에 할당
		int maxValue = maxValueFinder(itemNum - 1, weightLimit);
		
		// valueOf() 및 write() 메서드를 사용해 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// maxValueFinder() 메서드 정의
	public static int maxValueFinder(int itemNum, int weightLimit) {
		
		// 물품이 존재하지 않는 경우 0 반환
		if (itemNum < 0)
			return 0;
		
		// 해당 물품 조합 및 무게의 가치합이 존재하지 않는 경우
		if (maxValues[itemNum][weightLimit] == null) {
			
			// 현재 물품을 배낭에 담지 못하는 경우
			if (itemInfo[itemNum][0] > weightLimit) {
				
				// maxValueFinder() 메서드를 재귀 호출해 해당 물품을 선택하지 않았을 때의 가치합을 maxValues에 저장
				maxValues[itemNum][weightLimit] = maxValueFinder(itemNum - 1, weightLimit);
				
			// 현재 물품을 배낭에 담을 수 있는 경우
			} else {
				
				// maxValueFinder() 메서드를 재귀 호출해 해당 물품을 선택했을 때와 선택하지 않았을 때의 가치합을 각 변수에 할당
				int selected = maxValueFinder(itemNum - 1, weightLimit - itemInfo[itemNum][0]) + itemInfo[itemNum][1];
				int notSelected = maxValueFinder(itemNum - 1, weightLimit);
				
				// max() 메서드를 사용해 더 큰 경우를 maxValues에 저장
				maxValues[itemNum][weightLimit] = Math.max(selected, notSelected);
			}
		}
		
		// 해당 아이템 조합 및 무게의 가치합을 반환
		return maxValues[itemNum][weightLimit];
	}
}