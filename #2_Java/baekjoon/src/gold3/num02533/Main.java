package gold3.num02533;

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
	
	// 정점의 개수를 저장할 변수 nodeNum 초기화
	static int nodeNum;
	
	// 각 친구의 얼리 아답터 여부 확인 및 연결 관계를 저장할 각 배열 초기화
	static boolean[] adopted;
	static List<Integer>[] edges;
	
	// 각 사람이 얼리 아답터인지 여부에 따른 최소 얼리 아답터 수를 저장할 2차원 배열 earlyAdopters 초기화
	static int[][] earlyAdopters;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수를 변수 nodeNum에 할당
		nodeNum = Integer.parseInt(in.readLine());
		
		// 각 친구의 얼리 아답터 여부 확인 및 연결 관계를 저장할 각 배열 초기화
		adopted = new boolean[nodeNum + 1];
		edges = new ArrayList[nodeNum + 1];
		
		// 각 사람이 얼리 아답터인지 여부에 따른 최소 얼리 아답터 수를 저장할 2차원 배열 earlyAdopters 초기화
		earlyAdopters = new int[nodeNum + 1][2];
		
		// for 반복문을 사용해 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 두 정점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 간선의 정보를 배열 edges에 저장
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// adopterCounter() 메서드를 호출해 최소 얼리 아답터 수를 갱신
		adopterCounter(1);
		
		// min(), valueOf(), write() 메서드를 사용해 최소 얼리 아답터의 수를 출력
		out.write(String.valueOf(Math.min(earlyAdopters[1][0], earlyAdopters[1][1])));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// adopterCounter() 메서드 정의
	public static void adopterCounter(int curNode) {
		
		// 해당 사람이 얼리 아답터인지 확인한 경우 메서드 종료
		if (adopted[curNode])
			return;
		
		// 해당 사람을 얼리 아답터인지 확인한 것으로 처리
		adopted[curNode] = true;
		
		// 해당 사람이 얼리 아답터인지에 따른 최소 얼리 아답터의 수를 초기화
		earlyAdopters[curNode][1] = 1;
		
		// for 반복문을 사용해 연결된 다른 사람을 순회
		for (int nextNode : edges[curNode]) {
			
			// 해당 사람이 얼리 아답터인지 확인한 경우 다음 사람을 순회
			if (adopted[nextNode])
				continue;
			
			// adopterCounter() 메서드 재귀 호출
			adopterCounter(nextNode);
			
			// 해당 사람이 얼리 아답터인지에 따른 최소 얼리 아답터의 수를 갱신
			earlyAdopters[curNode][0] += earlyAdopters[nextNode][1];
			earlyAdopters[curNode][1] += Math.min(earlyAdopters[nextNode][0], earlyAdopters[nextNode][1]);
		}
	}
}