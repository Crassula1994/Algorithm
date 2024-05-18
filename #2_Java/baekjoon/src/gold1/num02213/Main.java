package gold1.num02213;

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
	
	// 정점의 가중치와 확인 여부, 간선의 정보를 저장할 각 배열 초기화
	static int[] weights;
	static boolean[] checked;
	static List<Integer>[] edges;
	
	// 각 정점이 독립집합에 포함되는지 여부에 따른 최대 가중치를 저장할 2차원 배열 maxWeights 초기화
	static int[][] maxWeights;
	
	// 최대 독립집합에 속한 정점을 저장할 List 객체 maxSet 초기화
	static List<Integer> maxSet = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정점의 수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 정점의 가중치와 확인 여부, 간선의 정보를 저장할 각 배열 초기화
		weights = new int[nodeNum + 1];
		checked = new boolean[nodeNum + 1];
		edges = new ArrayList[nodeNum + 1];
		
		// 각 정점이 독립집합에 포함되는지 여부에 따른 최대 가중치를 저장할 2차원 배열 maxWeights 초기화
		maxWeights = new int[nodeNum + 1][2];
		
		// for 반복문을 사용해 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 정점의 가중치를 배열 weights에 저장
		for (int idx = 1; idx < weights.length; idx++)
			weights[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 각 간선을 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결된 두 정점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 간선의 정보를 배열 edges에 저장
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// weightCalculator() 메서드를 호출해 각 정점이 독립집합에 포함되는지 여부에 따른 최대 가중치를 갱신
		weightCalculator(1);
		
		// 각 정점의 확인 여부를 저장할 배열 calculated 초기화
		checked = new boolean[nodeNum + 1];
		
		// 시작 정점이 독립집합에 포함되지 않는 것이 독립집합의 크기가 더 큰 경우
		if (maxWeights[1][0] > maxWeights[1][1]) {
			
			// write() 메서드를 사용해 독립집합의 크기를 출력
			out.write(maxWeights[1][0] + "\n");
			
			// maxSetFinder() 메서드를 호출해 최대 독립집합에 포함된 정점을 갱신
			maxSetFinder(1, false);
		
		// 시작 정점이 독립집합에 포함되지 않는 것이 독립집합의 크기가 더 작거나 같은 경우
		} else {
			
			// write() 메서드를 사용해 독립집합의 크기를 출력
			out.write(maxWeights[1][1] + "\n");
			
			// maxSetFinder() 메서드를 호출해 최대 독립집합에 포함된 정점을 갱신
			maxSetFinder(1, true);
		}
		
		// sort() 메서드를 사용해 최대 독립집합에 포함된 정점을 오름차순으로 정렬
		Collections.sort(maxSet);
		
		// for 반복문을 사용해 최대 독립집합에 포함된 정점을 출력
		for (int node : maxSet)
			out.write(node + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// weightCalculator() 메서드 정의
	public static void weightCalculator(int curNode) {
		
		// 현재 정점의 최대 가중치를 이미 계산한 경우 메서드 종료
		if (checked[curNode])
			return;
		
		// 현재 정점이 독립집합에 포함되는지에 따른 최대 가중치를 초기화
		maxWeights[curNode][0] = 0;
		maxWeights[curNode][1] = weights[curNode];
		
		// 현재 정점의 최대 가중치를 계산한 것으로 처리
		checked[curNode] = true;
		
		// for 반복문을 사용해 연결된 각 정점을 순회
		for (int nextNode : edges[curNode]) {
			
			// 해당 정점의 최대 가중치를 이미 계산한 경우 다음 정점을 순회
			if (checked[nextNode])
				continue;
			
			// weightCalculator() 메서드 재귀 호출
			weightCalculator(nextNode);
			
			// max() 메서드를 사용해 현재 정점이 독립지에 포함되는지에 따른 최대 가중치를 갱신
			maxWeights[curNode][0] += Math.max(maxWeights[nextNode][0], maxWeights[nextNode][1]);
			maxWeights[curNode][1] += maxWeights[nextNode][0]; 
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// maxSetFinder() 메서드 정의
	public static void maxSetFinder(int curNode, boolean isIncluded) {
		
		// 현재 정점을 확인한 것으로 처리
		checked[curNode] = true;
		
		// 해당 정점이 포함된 경우 해당 정점을 maxSet에 추가
		if (isIncluded)
			maxSet.add(curNode);

		// for 반복문을 사용해 해당 정점과 연결된 다른 정점을 순회
		for (int nextNode : edges[curNode]) {
			
			// 해당 정점을 이미 확인한 경우 다음 정점을 순회
			if (checked[nextNode])
				continue;

			// 현재 정점이 포함된 경우 다음 정점은 포함하지 않은 것으로 상정해 maxSetFinder() 메서드 재귀 호출
			if (isIncluded) {
				maxSetFinder(nextNode, false);
			
			// 현재 정점이 포함되지 않은 경우
			} else {
				
				// 다음 정점이 포함되지 않은 것이 더 크기가 큰 경우 포함되지 않은 것으로 상정해 maxSetFinder() 메서드 재귀 호출
				if (maxWeights[nextNode][0] > maxWeights[nextNode][1]) {
					maxSetFinder(nextNode, false);
					
				// 다음 정점이 포함된 것이 더 크기가 크거나 같은 경우 포함된 것으로 상정해 maxSetFinder() 메서드 재귀 호출
				} else {
					maxSetFinder(nextNode, true);
				}
			}
		}
	}
}