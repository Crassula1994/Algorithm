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
	
	// 각 물품의 무게와 가치, 각 물건들의 가치합의 최댓값을 저장할 각 2차원 배열 초기화
	static int[][] itemInfo;
	static int[][] maxValues;
	
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
		
		// 각 물품의 무게와 가치, 각 물건들의 가치합의 최댓값을 저장할 각 2차원 배열 초기화
		itemInfo = new int[itemNum][2];
		maxValues = new int[itemNum][weightLimit + 1];
		
		// maxValueFinder() 메서드를 호출해 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 변수 maxValue에 할당
		int maxValue = maxValueFinder(itemNum, weightLimit);
		
		// valueOf() 및 write() 메서드를 사용해 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// maxValueFinder() 메서드 정의
	public static int maxValueFinder(int itemNum, int weightLimit) {
		
		
		
		return maxValues[itemNum - 1][weightLimit];
	}
}