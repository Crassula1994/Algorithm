package gold5.num01717;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 집합의 부모 집합을 저장할 배열 rootSet 초기화
	static int[] rootSet;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집합 원소의 최고값 및 연산의 개수를 각 변수에 할당
		int maxElement = Integer.parseInt(st.nextToken());
		int calcCnt = Integer.parseInt(st.nextToken());
		
		// 각 집합의 부모 집합을 저장할 배열 rootSet 초기화
		rootSet = new int[maxElement + 1];
		
		// for 반복문을 사용해 각 집합의 부모 집합을 초기화
		for (int idx = 0; idx < rootSet.length; idx++)
			rootSet[idx] = idx;
		
		// for 반복문을 사용해 각 연산을 순회
		for (int calc = 0; calc < calcCnt; calc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연산의 종류, 연산 대상 집합을 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int setA = Integer.parseInt(st.nextToken());
			int setB = Integer.parseInt(st.nextToken());
			
			// 합집합 연산인 경우 setUnion() 메서드를 호출해 합집합 연산을 수행
			if (category == 0) {
				setUnion(setA, setB);
			
			// 두 집합이 같은 집합에 포함되어 있는지를 확인하는 연산인 경우
			} else {
				
				// 두 집합이 같은 집합에 포함되어 있는 경우 'YES' 출력
				if (setFinder(setA) == setFinder(setB)) {
					out.write("YES");
				
				// 두 집합이 같은 집합에 포함되어 있지 않은 경우 'no' 출력
				} else {
					out.write("NO");
				}
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// setUnion() 메서드 정의
	public static void setUnion(int setA, int setB) {
		
		// setFinder() 매서드를 호출해 각 집합의 부모 집합을 각 변수에 할당
		int rootA = setFinder(setA);
		int rootB = setFinder(setB);
		
		// 두 집합의 부모 집합이 다른 경우 부모 집합을 갱신
		if (rootA != rootB)
			rootSet[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// setFinder() 메서드 정의
	public static int setFinder(int set) {
		
		// 부모 집합이 자기 자신인 경우 자기 자신을 반환
		if (rootSet[set] == set)
			return set;
		
		// setFinder() 메서드를 재귀 호출해 부모 집합을 찾아 반환
		return rootSet[set] = setFinder(rootSet[set]);
	}
}