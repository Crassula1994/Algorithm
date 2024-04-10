package gold4.num20040;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 점과 연결된 부모 점을 저장할 배열 rootDot 초기화
	static int[] rootDot;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수 및 진행된 차례의 수를 각 변수에 할당
		int dotNum = Integer.parseInt(st.nextToken());
		int turnCnt = Integer.parseInt(st.nextToken());
		
		// 사이클이 처음 만들어진 차례를 저장할 변수 cycleTurn 초기화
		int cycleTurn = 0;
		
		// 각 점과 연결된 부모 점을 저장할 배열 rootDot 초기화
		rootDot = new int[dotNum];
		
		// for 반복문을 사용해 각 점과 연결된 부모 점을 갱신
		for (int idx = 1; idx < rootDot.length; idx++)
			rootDot[idx] = idx;
		
		// for 반복문을 사용해 각 차례를 순회
		for (int turn = 1; turn <= turnCnt; turn++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결할 두 점을 각 변수에 할당
			int dotA = Integer.parseInt(st.nextToken());
			int dotB = Integer.parseInt(st.nextToken());
			
			// 두 점을 연결 시 사이클이 만들어지는 경우 사이클이 처음 만들어진 차례를 갱신 후 반복문 탈출
			if (dotFinder(dotA) == dotFinder(dotB)) {
				cycleTurn = turn;
				break;
			}
			
			// dotConnector() 메서드를 호출해 두 점을 연결
			dotConnector(dotA, dotB);
		}
		
		// valueOf() 및 write() 메서드를 사용해 사이클이 처음 만들어진 차례의 번호를 출력
		out.write(String.valueOf(cycleTurn));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dotConnector() 메서드 정의
	public static void dotConnector(int dotA, int dotB) {
		
		// dotFinder() 메서드를 호출해 두 점의 부모 점을 찾아 각 변수에 할당
		int rootA = dotFinder(dotA);
		int rootB = dotFinder(dotB);
		
		// 두 점의 부모 점이 서로 다른 경우 두 점을 연결 처리
		if (rootA != rootB)
			rootDot[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dotFinder() 메서드 정의
	public static int dotFinder(int dot) {
		
		// 해당 점의 부모 점이 자신인 경우 해당 점을 반환
		if (rootDot[dot] == dot)
			return dot;
		
		// dotFinder() 메서드를 재귀 호출해 해당 점의 부모 점을 찾아 반환
		return rootDot[dot] = dotFinder(rootDot[dot]);
	}
}