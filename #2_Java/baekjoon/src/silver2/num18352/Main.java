package silver2.num18352;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 정보를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		int targetDist = Integer.parseInt(st.nextToken());
		int startCity = Integer.parseInt(st.nextToken());
		
		// 각 도시의 연결 정보를 저장할 배열 connection 초기화
		@SuppressWarnings("unchecked")
		List<Integer>[] connection = new ArrayList[cityNum + 1];
		
		// for 반복문을 사용해 각 도시의 연결 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < connection.length; idx++)
			connection[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 입력 받은 각 도로의 정보를 순회
		for (int r = 0; r < roadNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로의 시작 도시와 끝 도시를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 각 도로의 정보를 배열 connection에 저장
			connection[start].add(end);
		}
		
		// 각 도시의 시작 도시로부터의 거리를 저장할 배열 distances 초기화
		Integer[] distances = new Integer[cityNum + 1];
		
		// 방문할 도시의 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// 목표한 거리의 도시를 오름차순으로 정렬할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Integer> sorter = new PriorityQueue<>();
		
		// offer() 메서드를 사용해 시작 도시를 visitList에 추가 및 방문 처리
		visitList.offer(startCity);
		distances[startCity] = 0;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 도시를 변수 currentCity에 할당
			int currentCity = visitList.poll();
			
			// 현재 방문 중인 도시의 거리가 목표로 하는 거리인 경우 sorter에 추가
			if (distances[currentCity] == targetDist) {
				sorter.offer(currentCity);
				
			// 현재 방문 중인 도시의 거리가 목표로 하는 거리보다 먼 경우 반복문 탈출
			} else if (distances[currentCity] > targetDist) {
				break;
			}
			
			// for 반복문을 사용해 현재 방문 중인 도시와 연결된 도시를 순회
			for (int idx = 0; idx < connection[currentCity].size(); idx++) {
				
				// get() 메서드를 사용해 연결된 도시를 변수 nextCity에 할당
				int nextCity = connection[currentCity].get(idx);
				
				// 해당 도시를 이미 방문한 경우 다음 도시를 순회
				if (distances[nextCity] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 도시를 visitList에 추가 및 방문 처리
				visitList.offer(nextCity);
				distances[nextCity] = distances[currentCity] + 1;
			}
		}
		
		// 최단 거리가 목표 거리인 도시가 존재하지 않는 경우 -1을 출력
		if (sorter.isEmpty()) {
			out.write(String.valueOf(-1));
		
		// 최단 거리가 목표 거리인 도시가 존재하는 경우
		} else {
			
			// while 반복문을 사용해 오름차순으로 도시의 번호를 출력
			while (!sorter.isEmpty())
				out.write(sorter.poll() + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}