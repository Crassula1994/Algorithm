package silver1.num06584;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 정점의 개수 및 가장 긴 도로의 길이를 저장할 각 변수 초기화
	static int nodeNum;
	static int maxLength;
	
	// 두 정점 사이의 간선 정보를 저장할 2차원 배열 edges 초기화
	static boolean[][] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점과 간선의 개수를 각 변수에 할당
			nodeNum = Integer.parseInt(st.nextToken());
			int edgeNum = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (nodeNum == 0 && edgeNum == 0)
				break;
			
			// 가장 긴 도로의 길이를 저장할 변수 maxLength 초기화
			maxLength = 0;
			
			// 두 정점 사이의 간선 정보를 저장할 2차원 배열 edges 초기화
			edges = new boolean[nodeNum][nodeNum];
			
			// while 반복문을 사용해 각 간선 정보를 순회
			while (edgeNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 간선이 연결하는 두 정점을 각 변수에 할당
				int startNode = Integer.parseInt(st.nextToken());
				int endNode = Integer.parseInt(st.nextToken());
				
				// 두 정점 사이의 간선 정보를 2차원 배열 edges에 저장
				edges[startNode][endNode] = true;
				edges[endNode][startNode] = true;
			}
			
			// for 반복문을 사용해 가장 긴 도로의 길이를 갱신
			for (int startNode = 0; startNode < nodeNum; startNode++)
				lengthCalculator(startNode, 0);
			
			// write() 메서드를 사용해 가장 긴 도로의 길이를 출력
			out.write(maxLength + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lengthCalculator() 메서드 정의
	public static void lengthCalculator(int curNode, int length) {
		
		// max() 메서드를 사용해 가장 긴 도로의 길이를 갱신
		maxLength = Math.max(length, maxLength);
		
		// for 반복문을 사용해 각 정점을 순회
		for (int nextNode = 0; nextNode < nodeNum; nextNode++) {
			
			// 해당 정점으로 이동할 수 없는 경우 다음 정점을 순회
			if (!edges[curNode][nextNode])
				continue;
			
			// 해당 간선을 사용한 것으로 처리
			edges[curNode][nextNode] = false;
			edges[nextNode][curNode] = false;
			
			// lengthCalculator() 메서드 재귀 호출
			lengthCalculator(nextNode, length + 1);
			
			// 해당 간선을 사용하지 않은 것으로 원상 복구
			edges[curNode][nextNode] = true;
			edges[nextNode][curNode] = true;
		}
	}
}