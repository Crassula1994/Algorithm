package gold3.num27915;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 방의 개수 및 깊이가 홀수인 방의 개수를 저장할 각 변수 초기화
	static int chamberNum;
	static int oddCount = 0;
	
	// 각 방의 자식 방과 그 깊이가 홀수인지 여부를 저장할 각 배열 초기화
	static List<Integer>[] chambers;
	static boolean[] isOdd;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 방의 개수를 변수 chamberNum에 할당
		chamberNum = Integer.parseInt(in.readLine());
		
		// 각 방의 자식 방과 그 깊이가 홀수인지 여부를 저장할 각 배열 초기화
		chambers = new ArrayList[chamberNum + 1];
		isOdd = new boolean[chamberNum + 1];
		
		// for 반복문을 사용해 각 방의 자식 방을 저장할 List 객체 초기화
		for (int idx = 0; idx < chambers.length; idx++)
			chambers[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 방의 부모 방에 해당 방을 추가
		for (int number = 2; number <= chamberNum; number++)
			chambers[Integer.parseInt(st.nextToken())].add(number);
		
		// oddChamberCounter() 메서드를 호출해 깊이가 홀수인 방의 개수를 갱신
		oddChamberCounter(1);
		
		/* 하나의 기업은 깊이가 각각 짝수, 홀수인 최대 2개의 방을 채굴할 수 있으므로
		max() 메서드를 사용해 필요한 기업의 최소 개수를 변수 minCount에 할당 */
		int minCount = Math.max(oddCount, chamberNum - oddCount);
		
		// valueOf() 및 write() 메서드를 사용해 필요한 기업의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// oddChamberCounter() 메서드 정의
	public static void oddChamberCounter(int curChamber) {
		
		// for 반복문을 사용해 현재 방의 자식 방을 순회
		for (int nextChamber : chambers[curChamber]) {
			
			// 해당 방의 깊이가 홀수인지 여부를 갱신
			isOdd[nextChamber] = !isOdd[curChamber];
			
			// 해당 방의 깊이가 홀수인 경우 해당 개수를 갱신
			if (isOdd[nextChamber])
				oddCount++;
			
			// oddChamberCounter() 메서드 재귀 호출
			oddChamberCounter(nextChamber);
		}
	}
}