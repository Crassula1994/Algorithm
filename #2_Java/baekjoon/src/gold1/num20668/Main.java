package gold1.num20668;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 시간을 정수로 저장하기 위해 곱하는 값 및 정점까지의 최단 시간을 초기화하는 값을 나타낼 각 상수 초기화
	static final int MULTIPLIER = 2520;
	static final long INF = Long.MAX_VALUE;
	
	// 정점의 개수를 저장할 변수 nodeNum 초기화
	static int nodeNum;
	
	// 다음 정점에서의 속력 변화 및 각 간선의 연결 정보를 저장할 각 배열 초기화
	static int[] dv = {-1, 0, 1};
	static List<Edge>[] edges;
	
	// 각 속도에서 해당 정점까지의 최단 시간을 저장할 2차원 배열 minTimes 초기화
	static long[][] minTimes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Edge 클래스 정의
	static class Edge {
		
		// 간선의 목적지, 길이, 속도 제한을 저장할 각 변수 초기화
		int endNode;
		long length;
		int speedLimit;
		
		// 매개변수를 입력 받는 생성자 정의
		public Edge(int endNode, long length, int speedLimit) {
			this.endNode = endNode;
			this.length = length * MULTIPLIER;
			this.speedLimit = speedLimit;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// Node 클래스 정의
	static class Node implements Comparable<Node> {
		
		// 해당 정점의 번호, 현재까지 소요 시간, 현재 속도를 저장할 각 변수 초기화
		int number;
		long time;
		int speed;
		
		// 매개변수를 입력 받는 생성자 정의
		public Node(int number, long time, int speed) {
			this.number = number;
			this.time = time;
			this.speed = speed;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Node anotherNode) {
			
			// 더 소요 시간이 짧은 순서대로 정렬
			return Long.compare(this.time, anotherNode.time);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수 및 간선의 개수를 각 변수에 할당
		nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		
		// 목적지까지 이동할 때 걸리는 최단 시간을 저장할 변수 minTime 초기화
		long minTime = INF;
		
		// 각 간선의 연결 정보를 저장할 배열 edges 초기화
		edges = new ArrayList[nodeNum + 1];
		
		// 각 속도에서 해당 정점까지의 최단 시간을 저장할 2차원 배열 minTimes 초기화
		minTimes = new long[nodeNum + 1][11];
		
		// for 반복문을 사용해 각 간선의 연결 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 정점까지의 최단 시간을 초기화
		for (long[] speeds : minTimes)
			Arrays.fill(speeds, INF);
		
		// while 반복문을 사용해 각 간선을 순회
		while (edgeNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 간선의 연결 정보를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			int speedLimit = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 간선의 정보를 배열 edges에 저장
			edges[startNode].add(new Edge(endNode, length, speedLimit));
			edges[endNode].add(new Edge(startNode, length, speedLimit));
		}
		
		// minTimeCalculator() 메서드를 호출해 각 속도에서 해당 정점까지의 최단 시간을 갱신
		minTimeCalculator();
		
		// for 반복문을 사용해 목적지까지 이동할 때 걸리는 최단 시간을 갱신
		for (int speed = 1; speed <= 10; speed++)
			minTime = Math.min(minTimes[nodeNum][speed], minTime);
		
		// valueOf() 및 write() 메서드를 사용해 목적지까지 이동할 때 걸리는 최단 시간의 정수부를 출력
		out.write(String.valueOf(minTime / MULTIPLIER));
		
		// susbtinrg(), format(), write() 메서드를 사용해 목적지까지 이동할 때 걸리는 최단 시간의 소수부를 소숫점 아홉 자리까지 출력
		out.write(String.format("%.9f", (double) (minTime % MULTIPLIER) / MULTIPLIER).substring(1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minTimeCalculator() 메서드 정의
	public static void minTimeCalculator() {
		
		// 다음에 확인할 정점을 저장할 PriorityQueue 객체 nodeList 초기화
		PriorityQueue<Node> nodeList = new PriorityQueue<>();
		
		// offer() 메서드를 사용해 시작 정점의 정보를 nodeList에 추가
		nodeList.offer(new Node(1, 0, 1));
		
		// 시작 정점까지의 최단 시간을 초기화
		minTimes[1][1] = 0;
		
		// while 반복문을 사용해 trackList가 빌 때까지 순회
		while (!nodeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 정점을 변수 curNode에 할당
			Node curNode = nodeList.poll();
			
			// 현재 정점이 목적지인 경우 반복문 탈출
			if (curNode.number == nodeNum)
				break;
			
			// 현재 정점까지의 소요 시간이 저장된 최단 시간보다 긴 경우 다음 정점을 순회
			if (curNode.time > minTimes[curNode.number][curNode.speed])
				continue;
			
			// for 반복문을 사용해 각 연결된 간선을 순회
			for (Edge nextNode : edges[curNode.number]) {
				
				// for 반복문을 사용해 다음 정점에서의 각 속력 변화를 순회
				for (int d = 0; d < 3; d++) {
					
					// 다음 정점에서의 속력을 변수 nextSpeed에 할당
					int nextSpeed = curNode.speed + dv[d];
					
					// 속력이 1 미만이거나 해당 간선에서의 속도 제한을 초과하는 경우 다음 속력 변화를 순회
					if (nextSpeed < 1 || nextSpeed > nextNode.speedLimit)
						continue;
					
					// 다음 정점까지의 소요 시간을 계산해 변수 nextTime에 할당
					long nextTime = curNode.time + nextNode.length / nextSpeed;
					
					// 해당 정점까지의 소요 시간이 저장된 최단 시간보다 길거나 같은 경우 다음 속력 변화를 순회
					if (nextTime >= minTimes[nextNode.endNode][nextSpeed])
						continue;
					
					// offer() 메서드를 사용해 다음에 확인할 정점의 정보를 nodeList에 추가
					nodeList.offer(new Node(nextNode.endNode, nextTime, nextSpeed));
					
					// 다음 정점을 해당 속도로 이동했을 때의 최단 시간을 갱신
					minTimes[nextNode.endNode][nextSpeed] = nextTime;
				}
			}
		}
	}
}