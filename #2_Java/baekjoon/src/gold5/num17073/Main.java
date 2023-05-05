package gold5.num17073;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트리의 노드 수와 1번 노드에 고인 물의 양을 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int waterAmt = Integer.parseInt(st.nextToken());
		
		// 리프 노드의 수를 저장할 변수 leafNodeNum 초기화
		double leafNodeNum = 0;
		
		// 각 간선의 정보를 저장할 배열 edges 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {

			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결된 두 노드를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 간선의 정보를 추가
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// for 반복문을 사용해 각 노드를 순회
		for (int idx = 2; idx < edges.length; idx++) {
			
			// 해당 노드가 리프 노드인 경우 리프 노드의 수를 갱신
			if (edges[idx].size() == 1)
				leafNodeNum++;
		}
		
		// format() 및 write() 메서드를 사용해 각 정점에 쌓인 물의 양의 기댓값 평균을 출력
		out.write(String.format("%.10f", waterAmt / leafNodeNum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}