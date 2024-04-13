package silver1.num09934;

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
	
	// 완전 이진 트리의 깊이를 저장할 변수 depth 초기화
	static int depth;
	
	// 상근이가 방문한 빌딩의 순서, 깊이별로 빌딩의 번호를 저장할 각 배열 초기화
	static int[] buildings;
	static List<Integer>[] city;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 완전 이진 트리의 깊이를 변수 depth에 할당
		depth = Integer.parseInt(in.readLine());
		
		// pow() 메서드를 사용해 상근이가 방문한 빌딩의 순서, 깊이별로 빌딩의 번호를 저장할 각 배열 초기화
		buildings = new int[(int) Math.pow(2, depth) - 1];
		city = new ArrayList[depth];
		
		// for 반복문을 사용해 깊이별로 빌딩의 번호를 저장할 List 객체 초기화
		for (int idx = 0; idx < city.length; idx++)
			city[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 상근이가 방문한 빌딩의 순서를 배열 buildings에 저장
		for (int idx = 0; idx < buildings.length; idx++)
			buildings[idx] = Integer.parseInt(st.nextToken());
		
		// buildingFinder() 메서드를 호출해 깊이별로 빌딩의 번호를 갱신
		buildingFinder(0, buildings.length - 1, 0);
		
		// for 반복문을 사용해 각 깊이를 순회
		for (int idx = 0; idx < depth; idx++) {
			
			// for 반복문을 사용해 각 깊이의 모든 빌딩의 번호를 출력
			for (int building : city[idx])
				out.write(building + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// buildingFinder() 메서드 정의
	public static void buildingFinder(int start, int end, int curDepth) {

		// 현재 깊이가 마지막에 도달한 경우 메서드 종료
		if (curDepth == depth)
			return;
		
		// 중위 순회 시 현재 깊이에 위치한 빌딩을 찾기 위한 변수 mid 초기화
		int mid = (start + end) / 2;
		
		// add() 메서드를 사용해 해당 빌딩 번호를 해당 깊이에 추가
		city[curDepth].add(buildings[mid]);
		
		// buildingFinder() 메서드를 재귀 호출해 다음 깊이를 탐색
		buildingFinder(start, mid - 1, curDepth + 1);
		buildingFinder(mid + 1, end, curDepth + 1);
	}
}