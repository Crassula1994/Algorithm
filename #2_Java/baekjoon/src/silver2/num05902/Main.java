package silver2.num05902;

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
	
	// 매듭의 위치를 저장할 List 객체 knots 초기화
	static List<Integer> knots = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 매듭의 개수 및 밧줄의 길이를 각 변수에 할당
		int knotNum = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		// 매듭이 겹치도록 밧줄을 접을 수 있는 유효한 위치의 수를 저장할 변수 positionNum 초기화
		int positionNum = 0;
		
		// for 반복문을 사용해 각 매듭의 위치를 knots에 저장
		for (int knot = 0; knot < knotNum; knot++)
			knots.add(Integer.parseInt(in.readLine()));
		
		// sort() 메서드를 사용해 매듭의 위치를 오름차순으로 정렬
		Collections.sort(knots);
		
		// for 반복문을 사용해 각 매듭의 위치를 순회
		for (int idx = 0; idx < knots.size() - 1; idx++) {
			
			// positionChecker() 메서드를 호출해 매듭 사이의 가운데 위치에서 밧줄을 접을 수 있는 유효한 위치의 수를 갱신
			positionNum += positionChecker(idx, idx + 1);
			
			// 해당 매듭이 밧줄의 양끝에 위치한 것이 아닌 경우 밧줄을 접을 수 있는 유효한 위치의 수를 갱신
			if (idx != 0)
				positionNum += positionChecker(idx, idx);
		}
		
		// valueOf() 및 write() 메서드를 사용해 매듭이 겹치도록 밧줄을 접을 수 있는 유효한 위치의 수를 출력
		out.write(String.valueOf(positionNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// positionChecker() 메서드 정의
	public static int positionChecker(int leftIdx, int rightIdx) {
		
		// get() 메서드를 사용해 매듭을 접는 위치를 변수 position에 할당
		double position = (leftIdx == rightIdx) ? knots.get(leftIdx) : (knots.get(leftIdx) + knots.get(rightIdx)) / 2.0;
		
		// while 반복문을 사용해 각 매듭 쌍을 순회
		while (leftIdx-- > 0 && rightIdx++ < knots.size() - 1) {
			
			// get() 메서드를 사용해 각 매듭의 위치를 각 변수에 할당
			double leftKnot = knots.get(leftIdx);
			double rightKnot = knots.get(rightIdx);
			
			// 두 매듭이 서로 겹치지 않는 경우 0을 반환
			if (position - leftKnot != rightKnot - position)
				return 0;
		}
		
		// 각 매듭 쌍이 겹치는 경우 1을 반환
		return 1;
	}
}