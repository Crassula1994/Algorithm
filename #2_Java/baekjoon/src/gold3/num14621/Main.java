package gold3.num14621;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Road 클래스 정의
	static class Road {
		
		// 도로의 연결 대학교, 거리를 저장할 각 변수 초기화
		int startUniv;
		int endUniv;
		int distance;
		
		// 매개변수를 입력 받는 생성자 정의
		public Road(int startUniv, int endUniv, int distance) {
			this.startUniv = startUniv;
			this.endUniv = endUniv;
			this.distance = distance;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 대학교의 부모 대학교를 저장할 배열 parent 초기화
		int[] parent;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int univNum) {
			
			// 부모 대학교를 저장할 배열 parent 초기화
			parent = new int[univNum + 1];
			
			// for 반복문을 사용해 각 대학교의 부모 대학교를 초기화
			for (int idx = 1; idx < parent.length; idx++)
				parent[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int univ) {
			
			// 해당 대학교의 부모 대학교가 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (parent[univ] != univ)
				parent[univ] = find(parent[univ]);
			
			// 해당 대학교의 부모 대학교를 반환
			return parent[univ];
		}
		
		// union() 메서드 정의
		public void union(int univ1, int univ2) {
			
			// 두 대학교를 연결
			parent[find(univ1)] = find(univ2);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 대학교의 개수와 도로의 개수를 각 변수에 할당
		int univNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		
		// 각 대학교의 성비 정보를 저장할 배열 genderRatio 초기화
		char[] genderRatio = new char[univNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 대학교의 성비 정보를 배열 genderRatio에 저장
		for (int idx = 1; idx < genderRatio.length; idx++)
			genderRatio[idx] = st.nextToken().charAt(0);
		
		// 각 도로의 정보를 저장할 PriorityQueue 객체 roads 초기화 
		PriorityQueue<Road> roads = new PriorityQueue<>((r1, r2) -> {
			return r1.distance - r2.distance;
		});
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 대학교와 도로의 거리를 각 변수에 할당
			int startUniv = Integer.parseInt(st.nextToken());
			int endUniv = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// 성비가 불일치하는 대학교를 연결하는 도로만 roads에 추가
			if (genderRatio[startUniv] != genderRatio[endUniv])
				roads.offer(new Road(startUniv, endUniv, distance));
		}

		// 깽미가 만든 앱의 경로 길이 및 선택한 도로의 개수를 저장할 각 변수 초기화
		int totalDistance = 0;
		int roadCnt = 0;
		
		// 각 대학교의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(univNum);
		
		// while 반복문을 사용해 roads가 빌 때까지 순회
		while (!roads.isEmpty()) {
			
			// 모든 대학교 연결을 위해 필요한 도로를 모두 선택한 경우 반복문 탈출
			if (roadCnt == univNum - 1)
				break;
			
			// poll() 메서드를 사용해 가장 거리가 짧은 도로를 변수 road에 할당
			Road road = roads.poll();
			
			// 두 대학교 사이에 연결이 존재하지 않는 경우
			if (connection.find(road.startUniv) != connection.find(road.endUniv)) {
				
				// 두 대학교를 연결
				connection.union(road.startUniv, road.endUniv);
				
				// 깽미가 만든 앱의 경로 길이 및 선택한 도로의 개수를 갱신
				totalDistance += road.distance;
				roadCnt++;
			}
		}
		
		// 모든 대학교를 연결하는 경로가 없는 경우 -1 출력
		if (roadCnt < univNum - 1) {
			out.write(String.valueOf(-1));
		
		// 모든 대학교를 연결하는 경로가 있는 경우 깽미가 만든 앱의 경로 길이를 출력
		} else {
			out.write(String.valueOf(totalDistance));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}